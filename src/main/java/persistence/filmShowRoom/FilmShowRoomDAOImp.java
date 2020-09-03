package persistence.filmShowRoom;

import persistence.EntityDAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class FilmShowRoomDAOImp extends EntityDAOImpl<FilmShowRoomEntity> implements FilmShowRoomDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public FilmShowRoomDAOImp() {
        super(FilmShowRoomEntity.class);
    }

    @Override
    public FilmShowRoomEntity findByName(String filmShowRoomName) {
        TypedQuery<FilmShowRoomEntity> query = entityManager.createNamedQuery("FilmShowRoom.findByName", FilmShowRoomEntity.class);
        query.setParameter("filmShowRoomName", filmShowRoomName);
        return query.getSingleResult();
    }
}
