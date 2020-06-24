package persistence;

import domain.Seat;
;
import utils.Mapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

public class FilmShowRoomImp extends AbstractEntityDao<FilmShowRoomEntity> implements FilmShowRoomDAO {

    public FilmShowRoomImp(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, FilmShowRoomEntity.class);
    }

    @Override
    public Set<SeatEntity> getAllSeats(int filmShowRoomId) {
        EntityManager filmShowRoom = null;
        try {
            filmShowRoom = entityManagerFactory.createEntityManager();
            filmShowRoom.getTransaction().begin();
            TypedQuery<SeatEntity> query = filmShowRoom.createQuery("FROM SeatEntity s WHERE s.filmShowRoomEntity.filmShowRoomId =:filmShowRoomId", SeatEntity.class);
            query.setParameter("filmShowRoomId", filmShowRoomId);
            Set<SeatEntity> result = query.getResultStream().collect(Collectors.toSet());
            filmShowRoom.getTransaction().commit();
            return result;
        } finally {
            if (filmShowRoom != null) {
                filmShowRoom.close();
            }
        }
    }


}
