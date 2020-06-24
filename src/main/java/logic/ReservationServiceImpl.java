package logic;

import domain.Seans;
import domain.Seat;
import lombok.RequiredArgsConstructor;
import persistence.*;
import utils.Mapper;

import java.util.Set;
import java.util.stream.Collectors;

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
        ReservationEntity reservationEntity = new ReservationEntity(seans,client,seat);
        reservationDAO.save(reservationEntity);
    }

    @Override
    public Set<Seat> getAvailableSeats(Seans seans) {
        return reservationDAO.getAvailableSeats(Mapper.from(seans))
                .stream().map(Mapper::from)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Seat> getBookedSeats(Seans seans) {
        return null;
    }
}
