package persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class MovieDAOImpl extends EntityDAOImpl<MovieEntity> implements MovieDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public MovieDAOImpl() {
        super(MovieEntity.class);
    }

    @Override
    public MovieEntity findByMovieTitle(String title) {

        TypedQuery<MovieEntity> query = entityManager.createQuery("FROM MovieEntity WHERE MovieEntity.title =:title", MovieEntity.class);
        query.setParameter("title", title);
        return query.getSingleResult();
    }
}
