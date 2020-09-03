package logic.movie;

import domain.movie.Movie;
import domain.movie.MovieMapper;
import lombok.RequiredArgsConstructor;
import persistence.movie.MovieDAO;
import persistence.movie.MovieEntity;

import java.util.Set;

@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieDAO movieDAO;

    @Override
    public void addMovie(String title, String director, String description) {
        MovieEntity movieEntity = MovieEntity.builder()
                .title(title)
                .director(director)
                .description(description)
                .build();
        movieDAO.save(movieEntity);
    }

    @Override
    public Set<Movie> getAllMovies() {
        Set<MovieEntity> allMovies = movieDAO.getAllMovies();
        return MovieMapper.INSTANCE.movieEntityToMovie(allMovies);
    }

    @Override
    public Movie findByTitle(String title) {
        MovieEntity byTitle = movieDAO.findByTitle(title);
        return MovieMapper.INSTANCE.movieEntityToMovie(byTitle);
    }
}
