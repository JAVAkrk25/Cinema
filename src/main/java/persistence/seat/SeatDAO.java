package persistence.seat;

import domain.Seat;

public interface SeatDAO {
    void save (Seat seat);

    void delete (String seatId);
}
