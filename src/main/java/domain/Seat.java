package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Seat {
    private int seatId;
    private int row;
    private int seatNumber;
    private FilmShowRoom filmShowRoom;
}
