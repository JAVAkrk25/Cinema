package logic;

import domain.FilmShow;
import domain.Reservation;

import java.util.Set;

public interface ReservationService {

    Set<Reservation> getAllSeats(FilmShow filmShow);

    void bookSeat(String seatId, String filmShowId, String clientId);

}
