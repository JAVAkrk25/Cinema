package persistence;

import java.util.List;

public interface EntityDAO<T> {

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    T findById(Object id);

    List<T> list();
}
