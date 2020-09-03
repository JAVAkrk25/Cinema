package logic.seat;

import domain.seat.Seat;

import java.util.Set;

public interface SeatService {

    void addSeats(Integer rowNumber, Integer seatNumber, String filmShowRoomName);

    Set<Seat> getAllSeats(Integer filmShowRoomId);

    Set<Seat> getAllSeats(String filmShowRoomName);
}
