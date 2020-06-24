package persistence;

import domain.Seat;

import java.util.Set;

public interface SeatDAO extends  EntityDAO<SeatEntity> {

    Set<SeatEntity> getAllSeats(int filmShowRoomId);
}
