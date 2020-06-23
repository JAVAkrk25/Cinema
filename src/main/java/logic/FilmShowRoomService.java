package logic;

import domain.FilmShowRoom;
import domain.Seat;

import java.util.Set;

public interface FilmShowRoomService {
    void addFilmShowRoom(int filmShowRoomId);

    void addSeats(int seatId, int seatNumber, int row, FilmShowRoom filmShowRoom);

    Set<Seat> getAllSeats(int filmShowRoomId); //na postawie nr sali zwroci nam wszystkie mozliwe miejsca w sali, czyli kolekcje dostepnych dla sali siedzen
}
