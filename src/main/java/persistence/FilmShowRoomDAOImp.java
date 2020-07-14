package persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

;

public class FilmShowRoomDAOImp extends EntityDAOImpl<FilmShowRoomEntity> implements FilmShowRoomDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public FilmShowRoomDAOImp() {
        super(FilmShowRoomEntity.class);
    }

    @Override
    public Set<SeatEntity> getAllSeats(Integer filmShowRoomId) {

        TypedQuery<SeatEntity> query = entityManager.createQuery("FROM SeatEntity WHERE SeatEntity.filmShowRoomEntity.filmShowRomId =:filmShowRoomId", SeatEntity.class);
        query.setParameter("filmShowRoomId", filmShowRoomId);
        return query.getResultStream().collect(Collectors.toSet());
    }
}
