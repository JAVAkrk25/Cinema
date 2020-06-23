package logic;

import domain.FilmShowRoom;

public interface SeatService {
    void addSeats(int seatId, int row, int seatNumber, FilmShowRoom filmShowRoom);
}
