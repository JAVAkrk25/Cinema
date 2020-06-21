package logic;

import domain.FilmShowRoom;

public interface FilmShowRoomService {
    void addFilmShowRoom(int filmShowRoomId);

    void addSeats(int seatId, int seatNumber, int row, FilmShowRoom filmShowRoom);
}
