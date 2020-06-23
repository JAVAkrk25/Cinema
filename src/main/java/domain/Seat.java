package domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Seat {
    private int seatId;
    private int row;
    private int seatNumber;
    private FilmShowRoom filmShowRoom;

    public Seat(int seatId, int row, int seatNumber, FilmShowRoom filmShowRoom) {
        this.seatId = seatId;
        this.row = row;
        this.seatNumber = seatNumber;
        this.filmShowRoom = filmShowRoom;
    }
}
