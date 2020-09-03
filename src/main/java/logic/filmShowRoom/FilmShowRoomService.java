package logic.filmShowRoom;

import domain.filmShowRoom.FilmShowRoom;

public interface FilmShowRoomService {

    void addFilmShowRoom(String filmShowRoomName);

    FilmShowRoom getFilmShowRoom(Integer filmShowRoomId);

    FilmShowRoom getFilmShowRoom(String filmShowRoomName);
}
