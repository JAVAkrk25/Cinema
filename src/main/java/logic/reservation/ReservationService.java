package logic.reservation;

import domain.seans.Seans;
import domain.seat.Seat;

import java.util.Set;

public interface ReservationService {

    void bookSeat(Integer clientId, Integer seansId, Integer seatId);

    Set<Seat> getAvailableSeats(Seans seans);

    Set<Seat> getBookedSeats(Seans seans);

}
