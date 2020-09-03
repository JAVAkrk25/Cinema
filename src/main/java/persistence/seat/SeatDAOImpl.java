package persistence.seat;

import persistence.EntityDAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

public class SeatDAOImpl extends EntityDAOImpl<SeatEntity> implements SeatDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public SeatDAOImpl() {
        super(SeatEntity.class);
    }

    @Override
    public Set<SeatEntity> getAllSeats(Integer filmShowRoomId) {
        TypedQuery<SeatEntity> query = entityManager.createNamedQuery("SeatEntity.getAllSeatsByFilmShowRoomId", SeatEntity.class);
        query.setParameter("filmShowRoomId", filmShowRoomId);
        return query.getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Set<SeatEntity> getAllSeats(String filmShowRoomName) {
        TypedQuery<SeatEntity> query = entityManager.createNamedQuery("SeatEntity.getAllSeatsByFilmShowRoomName", SeatEntity.class);
        query.setParameter("filmShowRoomName", filmShowRoomName);
        return query.getResultStream().collect(Collectors.toSet());
    }
}
