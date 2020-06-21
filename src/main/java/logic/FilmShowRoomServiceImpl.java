package logic;

import domain.FilmShowRoom;
import domain.Seat;
import lombok.RequiredArgsConstructor;
import persistence.FilmShowRoomDAO;
import persistence.SeatDAO;

@RequiredArgsConstructor
public class FilmShowRoomServiceImpl implements FilmShowRoomService {
    private final FilmShowRoomDAO filmShowRoomDAO;
    private final SeatDAO seatDAO;

    @Override
    public void addFilmShowRoom(int filmShowRoomId) {
        FilmShowRoom filmShowRoom = new FilmShowRoom(filmShowRoomId);
        filmShowRoomDAO.save(filmShowRoom);
    }

    @Override
    public void addSeats(int seatId, int seatNumber, int row, FilmShowRoom filmShowRoom) {
        Seat seat = new Seat(seatId, seatNumber,row,new FilmShowRoom(Integer.parseInt(String.valueOf(filmShowRoom))));
    }
}
