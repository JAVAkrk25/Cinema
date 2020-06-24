package persistence;
;
import domain.Seans;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

public class SeansDAOImpl extends AbstractEntityDao<SeansEntity> implements SeansDAO {


    public SeansDAOImpl(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, SeansEntity.class);
    }

    @Override
    public Set<SeansEntity> getAllSeans(MovieEntity movie) {
        EntityManager emseans = null;
        try {
            emseans = entityManagerFactory.createEntityManager();
            emseans.getTransaction().begin();
            TypedQuery<SeansEntity> query = emseans.createQuery("FROM SeansEntity s WHERE s.movie.movieId =:movieId", SeansEntity.class);
            query.setParameter("movieId", movie.getMovieId());
            Set<SeansEntity> result = query.getResultStream().collect(Collectors.toSet());
            emseans.getTransaction().commit();
            return result;
        } finally {
            if (emseans != null) {
                emseans.close();
            }
        }
    }
}

