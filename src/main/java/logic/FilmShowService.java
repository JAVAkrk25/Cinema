package logic;

import java.time.LocalDateTime;

public interface FilmShowService {
    void addFilmShow(String filmShowId, LocalDateTime startTimeAndDate, String movieId, String filmShowRoomId);



}
