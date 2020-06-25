package persistence;

import domain.Seans;
import domain.Seat;

import java.util.Set;

public interface ReservationDAO  extends  EntityDAO<ReservationEntity> {

    Set<SeatEntity> getBookedSeats(SeansEntity seans);

    Set<SeatEntity> getAvailableSeats(SeansEntity seans);
}
