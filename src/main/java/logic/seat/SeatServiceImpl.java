package logic.seat;

import domain.seat.Seat;
import domain.seat.SeatMapper;
import lombok.RequiredArgsConstructor;
import persistence.filmShowRoom.FilmShowRoomDAO;
import persistence.filmShowRoom.FilmShowRoomEntity;
import persistence.seat.SeatDAO;
import persistence.seat.SeatEntity;

import java.util.Set;

@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final FilmShowRoomDAO filmShowRoomDAO;
    private final SeatDAO seatDAO;

    @Override
    public void addSeats(Integer rowNumber, Integer seatNumber, String filmShowRoomName) {
        FilmShowRoomEntity filmShowRoomEntity = filmShowRoomDAO.findByName(filmShowRoomName);
        SeatEntity seatEntity = SeatEntity.builder()
                .rowNumber(rowNumber)
                .seatNumber(seatNumber)
                .filmShowRoomEntity(filmShowRoomEntity)
                .build();
        seatDAO.save(seatEntity);
    }

    @Override
    public Set<Seat> getAllSeats(Integer filmShowRoomId) {
        Set<SeatEntity> allSeats = seatDAO.getAllSeats(filmShowRoomId);
        Set<Seat> seats = SeatMapper.INSTANCES.seatEntityToSeat(allSeats);
        return seats;
    }

    @Override
    public Set<Seat> getAllSeats(String filmShowRoomName) {
        Set<SeatEntity> allSeats = seatDAO.getAllSeats(filmShowRoomName);
        Set<Seat> seats = SeatMapper.INSTANCES.seatEntityToSeat(allSeats);
        return seats;
    }
}
