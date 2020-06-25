package logic;

import domain.FilmShowRoom;
import domain.Movie;
import domain.Seans;
import lombok.RequiredArgsConstructor;
import persistence.SeansDAO;
import utils.Mapper;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SeansServiceImpl implements SeansService {

    private final SeansDAO seansDAO;

    @Override
    public void addSeans(LocalDateTime startTimeAndDate, Movie movie, FilmShowRoom filmShowRoom) {
        Seans seans = new Seans(startTimeAndDate, movie, filmShowRoom);
        seansDAO.save(Mapper.from(seans));
    }

    @Override
    public Set<Seans> getAllSeans(Movie movie) {
        return seansDAO.getAllSeans(Mapper.from(movie))
                .stream().map(Mapper::from)
                .collect(Collectors.toSet());
    }
}
