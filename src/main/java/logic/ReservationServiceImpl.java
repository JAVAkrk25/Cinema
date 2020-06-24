package logic;

import domain.Client;
import domain.Reservation;
import domain.Seans;
import domain.Seat;
import lombok.RequiredArgsConstructor;
import persistence.reservation.ReservationDAO;
import utils.Mapper;

import java.util.Set;

@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationDAO reservationDAO;

    @Override
    public void bookSeat(int reservationId, String clientId, String seansId, String seatId) {
        // Reservation bookSeat = new Reservation(reservationId, new Client(clientId));
        //    reservationDAO.save(bookSeat);
    }

    @Override
    public Set<Seat> getAvailableSeats(Seans seans) {
        return null;
    }

    @Override
    public Set<Seat> getBookedSeats(Seans seans) {
        return null;
    }
}
