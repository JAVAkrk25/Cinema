package persistence.movie;
import domain.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieDAOImpl implements MovieDAO {
    private final EntityManagerFactory emf;

    public MovieDAOImpl (EntityManagerFactory emf) {this.emf = emf;}


    @Override
    public void save(Movie movie) {
        EntityManager mov = null;
        try {
            mov = emf.createEntityManager();
            mov.getTransaction().begin();
            mov.persist(from(movie));
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
            mov.merge(from(movie));
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
            TypedQuery<MovieEntity>query = em.createQuery("SELECT m FROM MovieEntity m", MovieEntity.class);
            Set<Movie> result = query.getResultStream().map(this::from).collect(Collectors.toSet());
            em.getTransaction().commit();
            return result;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    private Movie from(MovieEntity movieEntity) {
        return movieEntity == null ? null :
                new Movie(movieEntity.getMovieId(), movieEntity.getTitle(), movieEntity.getDirector(), movieEntity.getDuration());
    }

    private MovieEntity from(Movie movie) {
        return movie == null ? null :
                new MovieEntity(movie.getMovieId(), movie.getTitle(), movie.getDirector(), movie.getDuration());
    }
}