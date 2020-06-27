package logic;

import domain.Client;
import domain.Movie;

import java.util.List;
import java.util.Set;

public interface MovieService {
    void addMovie(String title, String director, String description);

    Set<Movie> getAllMovies();

    Movie findByMovieTitle (String title);

}
