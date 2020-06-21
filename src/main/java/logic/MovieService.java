package logic;

import domain.FilmShow;
import domain.Movie;

import java.util.Set;

public interface MovieService {
    void addMovie(String movieId, String title, String director, String duration);


    Set<Movie> getAllMovies();


    // Set<Movie> chooseMovieName(String movieId);

}
