package logic;

import domain.Movie;
import lombok.RequiredArgsConstructor;
import persistence.MovieDAO;
import utils.Mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieDAO movieDAO;

    @Override
    public void addMovie(String title, String director, String duration) {
        Movie movie = new Movie(title, director, duration);
        movieDAO.save(Mapper.from(movie));
    }

    @Override
    public Set<Movie> getAllMovies() {
        return movieDAO.list()
                .stream().map(Mapper::from)
                .collect(Collectors.toSet());
    }
}
