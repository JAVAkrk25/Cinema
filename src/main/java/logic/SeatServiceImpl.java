package logic;

import domain.FilmShowRoom;
import domain.Seat;
import lombok.RequiredArgsConstructor;
import persistence.FilmShowRoomDAO;
import persistence.FilmShowRoomEntity;
import persistence.SeatDAO;
import persistence.SeatEntity;
import utils.Mapper;

@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatDAO seatDAO;
    private final FilmShowRoomDAO filmShowRoomDAO;

    @Override
    public void addSeats(Integer row, Integer seatNumber, Integer filmShowRoomId) {
        FilmShowRoomEntity filmShowRoom = filmShowRoomDAO.findById(filmShowRoomId);
        SeatEntity seat = new SeatEntity(row, seatNumber, filmShowRoom);
        seatDAO.save(seat);
    }
}
