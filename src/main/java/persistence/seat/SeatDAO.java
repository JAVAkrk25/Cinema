package persistence.seat;

import domain.Seat;

import java.util.Set;

public interface SeatDAO {
    void save (Seat seat);

    void delete (String seatId);

    Set<Seat> getAllSeats(int filmShowRoomId);
}
