package persistence.filmShowRoom;

import persistence.EntityDAO;

public interface FilmShowRoomDAO extends EntityDAO<FilmShowRoomEntity> {

    FilmShowRoomEntity findByName(String filmShowRoomName);
}
