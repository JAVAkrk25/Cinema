package persistence.seans;

import domain.FilmShowRoom;
import domain.Movie;
import domain.Seans;
import lombok.RequiredArgsConstructor;
import persistence.seat.SeatEntity;
import persistence.filmShowRoom.FilmShowRoomEntity;
import persistence.movie.MovieEntity;
import utils.Mapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SeansDAOImpl implements SeansDAO {

    private final EntityManagerFactory emf;

    @Override
    public void save(Seans seans) {
        EntityManager seanses = null;
        try {
            seanses = emf.createEntityManager();
            seanses.getTransaction().begin();
            seanses.persist(Mapper.from(seans);
            seanses.getTransaction().commit();
        } finally {
            if (seanses != null) {
                seanses.close();
            }
        }
    }

    @Override
    public void delate(Seans seansId) {
        EntityManager seanses = null;
        try {
            seanses = emf.createEntityManager();
            seanses.getTransaction().begin();
            SeatEntity employeeEntity = seanses.find(SeatEntity.class, seansId);
            if (employeeEntity != null) {
                seanses.remove(employeeEntity);
            }
            seanses.getTransaction().commit();
        } finally {
            if (seanses != null) {
                seanses.close();
            }
        }
    }

    @Override
    public Set<Seans> getAllSeans(Movie movie) {
        EntityManager emseans = null;
        try {
            emseans = emf.createEntityManager();
            emseans.getTransaction().begin();
            TypedQuery<SeansEntity> query = emseans.createQuery("FROM SeansEntity s WHERE s.movie.movieId =:movieId", SeansEntity.class);
            query.setParameter("movieId", movie.getMovieId());
            Set<Seans> result = query.getResultStream().map(this::from).collect(Collectors.toSet());
            emseans.getTransaction().commit();
            return result;
        } finally {
            if (emseans != null) {
                emseans.close();
            }
        }
    }

    FilmShowRoom from(FilmShowRoomEntity filmShowroomEntity) {
        return null;
    }

    FilmShowRoomEntity from(FilmShowRoom filmShowroom) {
        return null;
    }

    Movie from(MovieEntity movieEntity) {
        return null;
    }

    MovieEntity from(Movie movie) {
        return null;
    }


}

