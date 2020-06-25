package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Seat {
    private Integer seatId;
    private int row;
    private int seatNumber;
    private FilmShowRoom filmShowRoom;

    public Seat(int row, int seatNumber, FilmShowRoom filmShowRoom) {
        this.row = row;
        this.seatNumber = seatNumber;
        this.filmShowRoom = filmShowRoom;
    }
}
