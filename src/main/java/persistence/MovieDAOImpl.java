package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class MovieDAOImpl extends AbstractEntityDao<MovieEntity> implements MovieDAO {

    public MovieDAOImpl(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, MovieEntity.class);
    }

    @Override
    public MovieEntity findByMovieTitle(String name) {
            EntityManager entityManager = null;
            try {
                entityManager = entityManagerFactory.createEntityManager();
                EntityTransaction transaction = entityManager.getTransaction();
                transaction.begin();

                TypedQuery<MovieEntity> query = entityManager.createQuery("FROM MovieEntity e WHERE c.title=:title", MovieEntity.class);
                query.setParameter("title", name);
                MovieEntity foundEntity = query.getSingleResult();
                transaction.commit();
                return foundEntity;
            } finally {
                if (entityManager != null){
                    entityManager.close();
                }
            }
        }
    }
