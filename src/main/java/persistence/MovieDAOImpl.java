package persistence;

import javax.persistence.EntityManagerFactory;

public class MovieDAOImpl extends AbstractEntityDao<MovieEntity> implements MovieDAO {

    public MovieDAOImpl(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, MovieEntity.class);
    }
}