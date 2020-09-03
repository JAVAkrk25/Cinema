package persistence.reservation;

import persistence.EntityDAO;
import persistence.seans.SeansEntity;
import persistence.seat.SeatEntity;

import java.util.Set;

public interface ReservationDAO extends EntityDAO<ReservationEntity> {

    Set<SeatEntity> getBookedSeats(SeansEntity seans);

    Set<SeatEntity> getAvailableSeats(SeansEntity seans);
}
