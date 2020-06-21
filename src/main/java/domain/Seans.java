package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Seans {
    private int seansId;
    private LocalDateTime startTimeAndDate;
    private Movie movie;
    private FilmShowRoom filmShowRoom;
}
