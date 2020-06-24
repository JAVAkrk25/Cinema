package logic;

import domain.FilmShowRoom;
import domain.Seat;
import lombok.RequiredArgsConstructor;
import persistence.SeatDAO;

@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatDAO seatDAO;

    @Override
    public void addSeats(int seatId, int row, int seatNumber, FilmShowRoom filmShowRoom) {
        Seat seat = new Seat(seatId,row,seatNumber,filmShowRoom);
        seatDAO.save(seat);
    }
}
