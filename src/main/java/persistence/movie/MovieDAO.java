package persistence.movie;

import persistence.EntityDAO;

import java.util.Set;

public interface MovieDAO extends EntityDAO<MovieEntity> {

    MovieEntity findByTitle(String title);

    Set<MovieEntity> getAllMovies();
}
