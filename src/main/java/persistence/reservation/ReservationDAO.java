package persistence.reservation;

import domain.Movie;
import domain.Reservation;
import domain.Seans;
import domain.Seat;

import java.util.Set;

public interface ReservationDAO {
    void save(Reservation reservation);

    void update(Reservation reservation);

    void delete(String reservationId);

    Set<Seat> getBookedSeats(Seans seans);

    Set<Seat> getAvailableSeats(Seans seans);
}
