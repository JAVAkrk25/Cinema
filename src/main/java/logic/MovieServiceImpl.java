package logic;

import domain.Movie;
import lombok.RequiredArgsConstructor;
import persistence.MovieDAO;

import java.util.Set;

@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieDAO movieDAO;


    @Override
    public void addMovie(int movieId, String title, String director, String duration) {
        Movie movie = new Movie(movieId, title, director, duration);
        movieDAO.save(movie);

    }

    @Override
    public Set<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }
}
