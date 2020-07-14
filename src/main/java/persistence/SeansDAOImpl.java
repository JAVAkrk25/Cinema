package persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

public class SeansDAOImpl extends EntityDAOImpl<SeansEntity> implements SeansDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public SeansDAOImpl() {
        super(SeansEntity.class);
    }

    @Override
    public Set<SeansEntity> getAllSeans(MovieEntity movie) {

        TypedQuery<SeansEntity> query = entityManager.createNamedQuery("SeansEntity.getAllSeans", SeansEntity.class);
        query.setParameter("movieId", movie.getMovieId());
        return query.getResultStream().collect(Collectors.toSet());
    }
}
