package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class FilmShow {
    private String filmShowId;
    private LocalDateTime startTimeAndDate;
    private String movieId;
    private String filmShowRoomId;
}
