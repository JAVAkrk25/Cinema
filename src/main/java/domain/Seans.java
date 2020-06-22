package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor

public class Seans {
    private int seansId;
    private LocalDateTime startTimeAndDate;
    private Movie movie;
    private FilmShowRoom filmShowRoom;
}
