package logic;

import domain.FilmShowRoom;
import domain.Seat;

import java.util.Set;

public interface FilmShowRoomService {
    void addFilmShowRoom();

    void addSeats(Integer row, Integer seatNumber, Integer filmShowRoomId);

    Set<Seat> getAllSeats(Integer filmShowRoomId); //na postawie nr sali zwroci nam wszystkie mozliwe miejsca w sali, czyli kolekcje dostepnych dla sali siedzen

    FilmShowRoom getFilmShowRoom(Integer id);

    FilmShowRoom findById(Integer filmShowRoomId);


}
