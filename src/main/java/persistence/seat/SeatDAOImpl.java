package persistence.seat;

import domain.FilmShowRoom;
import domain.Seans;
import domain.Seat;
import lombok.RequiredArgsConstructor;
import persistence.filmShowRoom.FilmShowRoomEntity;
import persistence.seans.SeansEntity;
import utils.Mapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SeatDAOImpl implements SeatDAO {

    private final EntityManagerFactory emf;

    @Override
    public void save(Seat seat) {
        EntityManager seats = null;
        try {
            seats = emf.createEntityManager();
            seats.getTransaction().begin();
            seats.persist(Mapper.from(seat));
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

    @Override
    public Set<Seat> getAllSeats(int filmShowRoomId) {
        EntityManager emseat = null;
        try {
            emseat = emf.createEntityManager();
            emseat.getTransaction().begin();
            TypedQuery<SeatEntity> query = emseat.createQuery("FROM SeatEntity s WHERE s.filmShowRoomEntity.filmShowRoomId =:filmShowRoomId", SeatEntity.class);
            query.setParameter("filmShowRoomId", filmShowRoomId);
            Set<Seat> result = query.getResultStream().map(Mapper::from).collect(Collectors.toSet());
            emseat.getTransaction().commit();
            return result;
        } finally {
            if (emseat != null) {
                emseat.close();
            }
        }
    }
}
