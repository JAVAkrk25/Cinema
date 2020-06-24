package persistence.filmShowRoom;

import domain.FilmShowRoom;
import domain.Movie;
import domain.Seat;
import lombok.RequiredArgsConstructor;
import persistence.filmShowRoom.FilmShowRoomDAO;
import persistence.filmShowRoom.FilmShowRoomEntity;
import persistence.movie.MovieEntity;
import persistence.seat.SeatEntity;
import utils.Mapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FilmShowRoomImp implements FilmShowRoomDAO {
    private final EntityManagerFactory emf;

    @Override
    public void save(FilmShowRoom filmShowRoom) {
        EntityManager filmShowRo = null;
        try {
            filmShowRo = emf.createEntityManager();
            filmShowRo.getTransaction().begin();
            filmShowRo.persist(Mapper.from(filmShowRoom));
            filmShowRo.getTransaction().commit();
        } finally {
            if (filmShowRo != null) {
                filmShowRo.close();
            }
        }
    }

    @Override
    public void delete(String filmShowRoomId) {
        EntityManager filmShowRo = null;
        try {
            filmShowRo = emf.createEntityManager();
            filmShowRo.getTransaction().begin();
            FilmShowRoomEntity employeeEntity = filmShowRo.find(FilmShowRoomEntity.class, filmShowRoomId);
            if (employeeEntity != null) {
                filmShowRo.remove(employeeEntity);
            }
            filmShowRo.getTransaction().commit();
        } finally {
            if (filmShowRo != null) {
                filmShowRo.close();
            }
        }
    }

    @Override
    public Set<Seat> getAllSeats(int filmShowRoomId) {
        EntityManager filmShowRoom = null;
        try {
            filmShowRoom = emf.createEntityManager();
            filmShowRoom.getTransaction().begin();
            TypedQuery<SeatEntity> query = filmShowRoom.createQuery("FROM SeatEntity s WHERE s.filmShowRoomEntity.filmShowRoomId =:filmShowRoomId", SeatEntity.class);
            query.setParameter("filmShowRoomId", filmShowRoomId);
            Set<Seat> result = query.getResultStream().map(Mapper::from).collect(Collectors.toSet());
            filmShowRoom.getTransaction().commit();
            return result;
        } finally {
            if (filmShowRoom != null) {
                filmShowRoom.close();
            }
        }
    }


}
