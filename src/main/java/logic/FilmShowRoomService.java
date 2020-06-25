package logic;

import domain.FilmShowRoom;
import domain.Seat;

import java.util.Set;

public interface FilmShowRoomService {
    void addFilmShowRoom(Integer filmShowRoomId);

    void addSeats(Integer seatId, Integer seatNumber, Integer row, FilmShowRoom filmShowRoomId);

    Set<Seat> getAllSeats(Integer filmShowRoomId); //na postawie nr sali zwroci nam wszystkie mozliwe miejsca w sali, czyli kolekcje dostepnych dla sali siedzen
}
