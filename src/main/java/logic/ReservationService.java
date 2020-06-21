package logic;

import domain.Seans;
import domain.Reservation;

import java.util.Set;

public interface ReservationService {

    Set<Reservation> getAllSeats(Seans seans);

    void bookSeat(String seatId, String filmShowId, String clientId);

}
