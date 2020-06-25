package logic;

import domain.FilmShowRoom;
import domain.Seat;
import lombok.RequiredArgsConstructor;
import persistence.SeatDAO;
import utils.Mapper;

@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatDAO seatDAO;

    @Override
    public void addSeats(Integer row, Integer seatNumber, FilmShowRoom filmShowRoom) {
        Seat seat = new Seat(row, seatNumber, filmShowRoom);
        seatDAO.save(Mapper.from(seat));
    }
}
