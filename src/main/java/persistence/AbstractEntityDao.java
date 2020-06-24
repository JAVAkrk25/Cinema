package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AbstractEntityDao<T> implements EntityDAO<T> {
    protected final EntityManagerFactory entityManagerFactory;
    private final Class<T> clazz;

    public AbstractEntityDao(EntityManagerFactory entityManagerFactory, Class<T> clazz){
        this.entityManagerFactory = entityManagerFactory;
        this.clazz = clazz;
    }

    public void save(T entity) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(entity);
            transaction.commit();
        } finally {
            if (entityManager != null){
                entityManager.close();
            }
        }
    }

    public void update(T entity) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            // short entityManager.getTransaction().begin();

            T managed = entityManager.merge(entity);

            transaction.commit();
        } finally {
            if (entityManager != null){
                entityManager.close();
            }
        }

    }

    public void delete(T courseEntity) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            T managed = entityManager.merge(courseEntity);
            entityManager.remove(managed);
            transaction.commit();
        } finally {
            if (entityManager != null){
                entityManager.close();
            }
        }
    }

    public T findById(Object id) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            T foundEntity = entityManager.find(clazz, id);
            transaction.commit();
            return foundEntity;
        } finally {
            if (entityManager != null){
                entityManager.close();
            }
        }
    }

    public List<T> list() {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            List<T> listOfEntities = entityManager.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
            transaction.commit();
            return listOfEntities;
        } finally {
            if (entityManager != null){
                entityManager.close();
            }
        }
    }

}