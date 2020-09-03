package persistence.movie;

import persistence.EntityDAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieDAOImpl extends EntityDAOImpl<MovieEntity> implements MovieDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public MovieDAOImpl(Class<MovieEntity> clazz) {
        super(clazz);
    }

    @Override
    public MovieEntity findByTitle(String title) {
        TypedQuery<MovieEntity> query = entityManager.createNamedQuery("MovieEntity.findByTitle", MovieEntity.class);
        query.setParameter("title", title);
        return query.getSingleResult();
    }

    @Override
    public Set<MovieEntity> getAllMovies() {
        TypedQuery<MovieEntity> query = entityManager.createNamedQuery("MovieEntity.getAllMovies", MovieEntity.class);
        return query.getResultStream().collect(Collectors.toSet());
    }
}
