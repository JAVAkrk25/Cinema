package logic;

import domain.FilmShow;
import domain.Movie;

import java.time.LocalDateTime;
import java.util.Set;

public interface FilmShowService {
    void addFilmShow(String filmShowId, LocalDateTime startTimeAndDate, String movieId, String filmShowRoomId);

    Set<FilmShow> getAllFilmShows(Movie movie);

}
