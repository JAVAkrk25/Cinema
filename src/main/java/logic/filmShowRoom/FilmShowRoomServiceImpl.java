package logic.filmShowRoom;

import domain.filmShowRoom.FilmShowRoom;
import domain.filmShowRoom.FilmShowRoomMapper;
import lombok.RequiredArgsConstructor;
import persistence.filmShowRoom.FilmShowRoomDAO;
import persistence.filmShowRoom.FilmShowRoomEntity;

@RequiredArgsConstructor
public class FilmShowRoomServiceImpl implements FilmShowRoomService {

    private final FilmShowRoomDAO filmShowRoomDAO;

    @Override
    public void addFilmShowRoom(String filmShowRoomName) {
        FilmShowRoom filmShowRoom = FilmShowRoom.builder()
                .filmShowRoomName(filmShowRoomName)
                .build();
        FilmShowRoomEntity filmShowRoomEntity = FilmShowRoomMapper.INSTANCE.filmShowRoomToFilmShowRoomEntity(filmShowRoom);
        filmShowRoomDAO.save(filmShowRoomEntity);
    }

    @Override
    public FilmShowRoom getFilmShowRoom(Integer filmShowRoomId) {
        FilmShowRoomEntity filmShowRoomEntity = filmShowRoomDAO.findById(filmShowRoomId);
        return FilmShowRoomMapper.INSTANCE.filmShowRoomEntityToFilmShowRoom(filmShowRoomEntity);
    }

    @Override
    public FilmShowRoom getFilmShowRoom(String filmShowRoomName) {
        FilmShowRoomEntity filmShowRoomEntity = filmShowRoomDAO.findByName(filmShowRoomName);
        return FilmShowRoomMapper.INSTANCE.filmShowRoomEntityToFilmShowRoom(filmShowRoomEntity);
    }
}
