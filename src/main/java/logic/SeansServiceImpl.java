package logic;

import domain.FilmShowRoom;
import domain.Movie;
import domain.Seans;
import lombok.RequiredArgsConstructor;
import persistence.seans.SeansDAO;

import java.time.LocalDateTime;
import java.util.Set;
@RequiredArgsConstructor
public class SeansServiceImpl implements SeansService {

    private final SeansDAO seansDAO;

    @Override
    public void addSeans(int seansId, LocalDateTime startTimeAndDate, Movie movie, FilmShowRoom filmShowRoom) {
        Seans seans = new Seans(seansId, startTimeAndDate,movie,filmShowRoom);
        seansDAO.save(seans);
    }

    @Override
    public Set<Seans> getAllSeans(Movie movie) {
        return seansDAO.getAllSeans(movie);
    }
}
