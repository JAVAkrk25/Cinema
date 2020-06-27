package logic;

import domain.FilmShowRoom;
import domain.Movie;
import domain.Seat;
import lombok.RequiredArgsConstructor;
import persistence.FilmShowRoomDAO;
import persistence.FilmShowRoomEntity;
import persistence.SeatDAO;
import persistence.SeatEntity;
import utils.Mapper;
import view.consol.logicPack.InterfaceMenuEntry;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FilmShowRoomServiceImpl implements FilmShowRoomService {
    private final FilmShowRoomDAO filmShowRoomDAO;
    private final SeatDAO seatDAO;

    @Override
    public void addFilmShowRoom() {
        FilmShowRoom filmShowRoom = new FilmShowRoom();
        filmShowRoomDAO.save(Mapper.from(filmShowRoom));
    }

    @Override
    public void addSeats(Integer row, Integer seatNumber, Integer filmShowRoomId) {
        FilmShowRoomEntity filmShowRoom = filmShowRoomDAO.findById(filmShowRoomId);
        SeatEntity seat = new SeatEntity(row, seatNumber, filmShowRoom);
        seatDAO.save(seat);
    }

    @Override
    public Set<Seat> getAllSeats(Integer filmShowRoomId) {
        return filmShowRoomDAO.getAllSeats(filmShowRoomId)
                .stream().map(Mapper::from)
                .collect(Collectors.toSet());
    }

    @Override
    public FilmShowRoom getFilmShowRoom(Integer id) {
        return Mapper.from(filmShowRoomDAO.findById(id));
    }

    @Override
    public FilmShowRoom findById(Integer filmShowRoomId) {
        return Mapper.from(filmShowRoomDAO.findById(filmShowRoomId));
    }

}
