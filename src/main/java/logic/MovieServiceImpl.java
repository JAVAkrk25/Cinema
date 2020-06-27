package logic;

import domain.Movie;
import lombok.RequiredArgsConstructor;
import persistence.MovieDAO;
import utils.Mapper;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieDAO movieDAO;

    @Override
    public void addMovie(String title, String director, String description) {
        Movie movie = new Movie(title, director, description);
        movieDAO.save(Mapper.from(movie));
    }

    @Override
    public Set<Movie> getAllMovies() {
        return movieDAO.list()
                .stream().map(Mapper::from)
                .collect(Collectors.toSet());
    }

    @Override
    public Movie findByMovieTitle(String title) {
        return Mapper.from(movieDAO.findByMovieTitle(title));
    }


}
