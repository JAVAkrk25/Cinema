package persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;


public class ReservationDAOImpl extends EntityDAOImpl<ReservationEntity> implements ReservationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public ReservationDAOImpl() {
        super(ReservationEntity.class);
    }

    @Override
    public Set<SeatEntity> getBookedSeats(SeansEntity seans) {

        TypedQuery<SeatEntity> query = entityManager.createNamedQuery("Reservation.SelectBookedSeatBySeans", SeatEntity.class);
        query.setParameter("seansEntity", seans);
        return query.getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Set<SeatEntity> getAvailableSeats(SeansEntity seans) {

        FilmShowRoomDAO filmShowRoomDAO = new FilmShowRoomDAOImp();
        Set<SeatEntity> allSeats = filmShowRoomDAO.getAllSeats(seans.getFilmShowRoomEntity().getFilmShowRoomId());
        Set<SeatEntity> bookedSeats = getBookedSeats(seans);
        allSeats.removeAll(bookedSeats);
        return allSeats;
    }
}
