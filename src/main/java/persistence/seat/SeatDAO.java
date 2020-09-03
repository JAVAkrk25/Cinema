package persistence.seat;

import persistence.EntityDAO;

import java.util.Set;

public interface SeatDAO extends EntityDAO<SeatEntity> {

    Set<SeatEntity> getAllSeats(Integer filmShowRoomId);

    Set<SeatEntity> getAllSeats(String filmShowRoomName);
}
