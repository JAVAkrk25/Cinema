package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;


public class ReservationDAOImpl extends  AbstractEntityDao<ReservationEntity> implements ReservationDAO {

    private final FilmShowRoomDAO filmShowRoomDAO;

    public ReservationDAOImpl(EntityManagerFactory entityManagerFactory, FilmShowRoomDAO filmShowRoomDAO) {
        super(entityManagerFactory, ReservationEntity.class);
        this.filmShowRoomDAO = filmShowRoomDAO;
    }

    @Override
    public Set<SeatEntity> getBookedSeats(SeansEntity seans) {
        EntityManager seanss = null;
        try {
            seanss = entityManagerFactory.createEntityManager();
            seanss.getTransaction().begin();
            TypedQuery<SeatEntity> query = seanss.createQuery("SELECT r.seatEntity FROM ReservationEntity r WHERE r.seansEntity = :seansEntity", SeatEntity.class);
            query.setParameter("seansEntity", seans);
            Set<SeatEntity> result = query.getResultStream().collect(Collectors.toSet());
            seanss.getTransaction().commit();
            return result;
        } finally {
            if (seanss != null) {
                seanss.close();
            }
        }
    }

    @Override
    public Set<SeatEntity> getAvailableSeats(SeansEntity seans) {
        Set<SeatEntity> allSeats = filmShowRoomDAO.getAllSeats(seans.getFilmShowRoomEntity().getFilmShowRoomId());
        Set<SeatEntity> bookedSeats = getBookedSeats(seans);
        allSeats.removeAll(bookedSeats);
        return allSeats;
    }
}
