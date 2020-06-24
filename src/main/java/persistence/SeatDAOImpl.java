package persistence;

import domain.Seat;
import lombok.RequiredArgsConstructor;
import utils.Mapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;


public class SeatDAOImpl extends  AbstractEntityDao<SeatEntity> implements SeatDAO {


    public SeatDAOImpl(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, SeatEntity.class);
    }

    @Override
    public Set<SeatEntity> getAllSeats(int filmShowRoomId) {
        EntityManager emseat = null;
        try {
            emseat = entityManagerFactory.createEntityManager();
            emseat.getTransaction().begin();
            TypedQuery<SeatEntity> query = emseat.createQuery("FROM SeatEntity s WHERE s.filmShowRoomEntity.filmShowRoomId =:filmShowRoomId", SeatEntity.class);
            query.setParameter("filmShowRoomId", filmShowRoomId);
            Set<SeatEntity> result = query.getResultStream().collect(Collectors.toSet());
            emseat.getTransaction().commit();
            return result;
        } finally {
            if (emseat != null) {
                emseat.close();
            }
        }
    }
}
