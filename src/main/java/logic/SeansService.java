package logic;

import domain.FilmShowRoom;
import domain.Seans;
import domain.Movie;

import java.time.LocalDateTime;
import java.util.Set;

public interface SeansService {
    void addSeans(String seansId, LocalDateTime startTimeAndDate, Movie movie, FilmShowRoom filmShowRoom);

    Set<Seans> getAllFilmShows(Movie movie);

}
