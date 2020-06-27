package persistence;

import domain.FilmShowRoom;
import domain.Seat;

import java.util.Set;

public interface FilmShowRoomDAO extends EntityDAO<FilmShowRoomEntity> {

    Set<SeatEntity> getAllSeats(Integer filmShowRoomId);

}
