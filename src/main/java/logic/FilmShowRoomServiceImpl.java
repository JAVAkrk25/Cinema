package logic;

import domain.FilmShowRoom;
import domain.Seat;
import lombok.RequiredArgsConstructor;
import persistence.FilmShowRoomDAO;
import persistence.FilmShowRoomEntity;
import persistence.SeatDAO;
import persistence.SeatEntity;
import utils.Mapper;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FilmShowRoomServiceImpl implements FilmShowRoomService {
    private final FilmShowRoomDAO filmShowRoomDAO;
    private final SeatDAO seatDAO;

    @Override
    public void addFilmShowRoom(Integer filmShowRoomId) {
        FilmShowRoom filmShowRoom = new FilmShowRoom(filmShowRoomId);
        filmShowRoomDAO.save(Mapper.from(filmShowRoom));
    }

    @Override
    public void addSeats(Integer seatId, Integer seatNumber, Integer row, FilmShowRoom filmShowRoom) {
        Seat seat = new Seat(seatId, seatNumber, row, filmShowRoom);
        seatDAO.save(Mapper.from(seat));
    }

    @Override
    public Set<Seat> getAllSeats(Integer filmShowRoomId) {
        return filmShowRoomDAO.getAllSeats(filmShowRoomId)
                .stream().map(Mapper::from)
                .collect(Collectors.toSet());
    }
}
