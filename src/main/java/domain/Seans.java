package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Seans {
    private Integer seansId;
    private LocalDateTime startTimeAndDate;
    private Movie movie;
    private FilmShowRoom filmShowRoom;

    public Seans(LocalDateTime startTimeAndDate, Movie movie, FilmShowRoom filmShowRoom) {
        this.startTimeAndDate = startTimeAndDate;
        this.movie = movie;
        this.filmShowRoom = filmShowRoom;
    }
}
