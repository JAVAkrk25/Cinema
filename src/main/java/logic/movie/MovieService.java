package logic.movie;

import domain.movie.Movie;

import java.util.Set;

public interface MovieService {

    void addMovie(String title, String director, String description);

    Set<Movie> getAllMovies();

    Movie findByTitle(String title);
}
