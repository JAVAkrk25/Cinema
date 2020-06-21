package persistence;

import domain.Client;
import domain.Movie;

import java.util.List;
import java.util.Set;

public interface MovieDAO {
    void save(Movie movie);

    void update(Movie movie);

    void delete(String movieId);

    Set<Movie> getAllMovies();
}
