package logic;

import domain.FilmShowRoom;
import lombok.RequiredArgsConstructor;
import persistence.FilmShowDAO;

@RequiredArgsConstructor
public class FilmShowRoomServiceImpl implements FilmShowRoomService {
    private final FilmShowDAO filmShowDAO;

    @Override
    public void addFilmShowRoom(FilmShowRoom filmShowRoom) {
        FilmShowRoom filmShowRoom1 = new FilmShowRoom(Integer.parseInt(String.valueOf(filmShowRoom)));
    }

    @Override
    public void addSeats(String seatId, int seatNumber, int row, FilmShowRoom filmShowRoom) {

    }
}
