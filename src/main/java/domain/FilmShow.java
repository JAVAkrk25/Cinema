package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class FilmShow {
    private int filmShowId;
    private LocalDateTime startTimeAndDate;
    private Movie movie;
    private FilmShowRoom filmShowRoom;
}
