package persistence.reservation;

import domain.Movie;
import domain.Reservation;

public interface ReservationDAO {
    void save(Reservation reservation);

    void update(Reservation reservation);

    void delete(String reservationId);
}
