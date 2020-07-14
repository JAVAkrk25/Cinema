package persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class EntityDAOImpl<T> implements EntityDAO<T> {

    private final Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    public EntityDAOImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T courseEntity) {
        T merge = entityManager.merge(courseEntity);
        entityManager.remove(merge);
    }

    public T findById(Object id) {
        return entityManager.find(clazz, id);
    }

    public List<T> list() {
        return entityManager.createQuery("SELECT * FROM " + clazz.getSimpleName(), clazz).getResultList();
    }
}
