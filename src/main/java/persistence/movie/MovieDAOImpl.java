package persistence.movie;

import domain.Movie;
import utils.Mapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieDAOImpl implements MovieDAO {
    private final EntityManagerFactory emf;

    public MovieDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(Movie movie) {
        EntityManager mov = null;
        try {
            mov = emf.createEntityManager();
            mov.getTransaction().begin();
            mov.persist(Mapper.from(movie));
            mov.getTransaction().commit();
        } finally {
            if (mov != null) {
                mov.close();
            }
        }
    }

    @Override
    public void update(Movie movie) {
        EntityManager mov = null;
        try {
            mov = emf.createEntityManager();
            mov.getTransaction().begin();
            mov.merge(Mapper.from(movie));
            mov.getTransaction().commit();
        } finally {
            if (mov != null) {
                mov.close();
            }
        }
    }

    @Override
    public void delete(String movieId) {
        EntityManager mov = null;
        try {
            mov = emf.createEntityManager();
            mov.getTransaction().begin();
            MovieEntity employeeEntity = mov.find(MovieEntity.class, movieId);
            if (employeeEntity != null) {
                mov.remove(employeeEntity);
            }
            mov.getTransaction().commit();
        } finally {
            if (mov != null) {
                mov.close();
            }
        }
    }

    @Override
    public Set<Movie> getAllMovies() {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            TypedQuery<MovieEntity> query = em.createQuery("SELECT m FROM MovieEntity m", MovieEntity.class);
            Set<Movie> result = query.getResultStream().map(Mapper::from).collect(Collectors.toSet());
            em.getTransaction().commit();
            return result;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}