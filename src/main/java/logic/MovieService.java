package logic;

import domain.Movie;

import java.util.Set;

public interface MovieService {
    void addMovie(int movieId, String title, String director, String duration);


    Set<Movie> getAllMovies();


    // Set<Movie> chooseMovieName(String movieId);

}
