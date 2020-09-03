package logic.reservation;

import domain.seans.Seans;
import domain.seans.SeansMapper;
import domain.seat.Seat;
import domain.seat.SeatMapper;
import lombok.RequiredArgsConstructor;
import persistence.client.ClientDAO;
import persistence.client.ClientEntity;
import persistence.reservation.ReservationDAO;
import persistence.reservation.ReservationEntity;
import persistence.seans.SeansDAO;
import persistence.seans.SeansEntity;
import persistence.seat.SeatDAO;
import persistence.seat.SeatEntity;

import java.util.Set;

@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationDAO reservationDAO;
    private final ClientDAO clientDAO;
    private final SeansDAO seansDAO;
    private final SeatDAO seatDAO;

    @Override
    public void bookSeat(Integer clientId, Integer seansId, Integer seatId) {
        ClientEntity client = clientDAO.findById(clientId);
        SeansEntity seans = seansDAO.findById(seansId);
        SeatEntity seat = seatDAO.findById(seatId);
        ReservationEntity reservationEntity = ReservationEntity.builder()
                .clientEntity(client)
                .seansEntity(seans)
                .seatEntity(seat)
                .build();
        reservationDAO.save(reservationEntity);
    }

    @Override
    public Set<Seat> getAvailableSeats(Seans seans) {
        Set<SeatEntity> availableSeats = reservationDAO.getAvailableSeats(SeansMapper.INSTANCE.seansToSeansEntity(seans));
        Set<Seat> seats = SeatMapper.INSTANCES.seatEntityToSeat(availableSeats);
        return seats;
    }

    @Override
    public Set<Seat> getBookedSeats(Seans seans) {
        Set<SeatEntity> bookedSeats = reservationDAO.getBookedSeats(SeansMapper.INSTANCE.seansToSeansEntity(seans));
        Set<Seat> seats = SeatMapper.INSTANCES.seatEntityToSeat(bookedSeats);
        return seats;
    }
}
