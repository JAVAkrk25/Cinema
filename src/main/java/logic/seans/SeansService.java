package logic.seans;

import domain.filmShowRoom.FilmShowRoom;
import domain.movie.Movie;
import domain.seans.Seans;

import java.time.LocalDateTime;
import java.util.Set;

public interface SeansService {
    void addSeans(Movie movie, FilmShowRoom filmShowRoom, LocalDateTime startTimeAndDate);

    Set<Seans> getAllSeans(Movie movie);
}
