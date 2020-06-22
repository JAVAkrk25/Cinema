package persistence;

import domain.FilmShowRoom;
import domain.Seat;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
public class SeatDAOImpl implements SeatDAO{

    private final EntityManagerFactory emf;

    @Override
    public void save(Seat seat) {
        EntityManager seats = null;
        try {
            seats = emf.createEntityManager();
            seats.getTransaction().begin();
            seats.persist(from(seat));
            seats.getTransaction().commit();
        } finally {
            if (seats != null) {
                seats.close();
            }
        }
    }

    @Override
    public void delete(String seatId) {
        EntityManager seats = null;
        try {
            seats = emf.createEntityManager();
            seats.getTransaction().begin();
            SeatEntity employeeEntity = seats.find(SeatEntity.class, seatId);
            if (employeeEntity != null) {
                seats.remove(employeeEntity);
            }
            seats.getTransaction().commit();
        } finally {
            if (seats != null) {
                seats.close();
            }
        }
    }

    FilmShowRoom from(FilmShowRoomEntity filmShowroomEntity) {
        return null;
    }

    FilmShowRoomEntity from(FilmShowRoom filmShowroom) {
        return null;
    }


    private Seat from(SeatEntity seatEntity) {
        return seatEntity == null ? null :
                new Seat(seatEntity.getSeatId(),seatEntity.getRow(),seatEntity.getSeatNumber(), from(seatEntity.getFilmShowRoomEntity()));
    }

    private SeatEntity from(Seat seats) {
        return seats == null ? null :
                new SeatEntity(seats.getSeatId(),seats.getRow(),seats.getSeatNumber(),from(seats.getFilmShowRoom()));
    }
}
