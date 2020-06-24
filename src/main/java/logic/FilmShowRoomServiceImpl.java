package logic;

import domain.FilmShowRoom;
import domain.Seat;
import lombok.RequiredArgsConstructor;
import persistence.filmShowRoom.FilmShowRoomDAO;
import persistence.seat.SeatDAO;

import java.util.Set;

@RequiredArgsConstructor
public class FilmShowRoomServiceImpl implements FilmShowRoomService {
    private final FilmShowRoomDAO filmShowRoomDAO;

    @Override
    public void addFilmShowRoom(int filmShowRoomId) {
        FilmShowRoom filmShowRoom = new FilmShowRoom(filmShowRoomId);
        filmShowRoomDAO.save(filmShowRoom);
    }

    @Override
    public void addSeats(int seatId, int seatNumber, int row, FilmShowRoom filmShowRoom) {
        Seat seat = new Seat(seatId, seatNumber,row,new FilmShowRoom(Integer.parseInt(String.valueOf(filmShowRoom))));
    }

    @Override
    public Set<Seat> getAllSeats(int filmShowRoomId) {
        return filmShowRoomDAO.getAllSeats(filmShowRoomId);
    }
}
