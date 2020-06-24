package persistence.filmShowRoom;

import domain.FilmShowRoom;
import domain.Seat;

import java.util.Set;

public interface FilmShowRoomDAO {
    void save (FilmShowRoom filmShowRoom);

    void delete (String filmShowRoomId);

    Set<Seat> getAllSeats(int filmShowRoomId);
}
