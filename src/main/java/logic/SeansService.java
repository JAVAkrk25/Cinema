package logic;

import domain.FilmShowRoom;
import domain.Movie;
import domain.Seans;

import java.time.LocalDateTime;
import java.util.Set;

public interface SeansService {
    void addSeans(LocalDateTime startTimeAndDate, Movie movie, FilmShowRoom filmShowRoom);

    Set<Seans> getAllSeans(Movie movie);

}
