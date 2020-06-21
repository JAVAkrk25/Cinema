package persistence;

import domain.FilmShowRoom;

public interface FilmShowRoomDAO {
    void save (FilmShowRoom filmShowRoom);

    void delete (String filmShowRoomId);
}
