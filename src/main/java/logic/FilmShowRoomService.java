package logic;

import domain.FilmShowRoom;

public interface FilmShowRoomService {
    void addFilmShowRoom(FilmShowRoom filmShowRoom);

    void addSeats(String seatId, int seatNumber, int row, FilmShowRoom filmShowRoom);
}
