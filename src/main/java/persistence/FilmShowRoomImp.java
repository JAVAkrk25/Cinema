package persistence;

import domain.FilmShowRoom;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
@RequiredArgsConstructor
public class FilmShowRoomImp implements FilmShowRoomDAO {
    private final EntityManagerFactory emf;


    @Override
    public void save(FilmShowRoom filmShowRoom) {
        EntityManager filmShowRo = null;
        try {
            filmShowRo = emf.createEntityManager();
            filmShowRo.getTransaction().begin();
            filmShowRo.persist(from(filmShowRoom));
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
            FilmShowroomEntity employeeEntity = filmShowRo.find(FilmShowroomEntity.class, filmShowRoomId);
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

    private FilmShowRoom from(FilmShowroomEntity fsr) {
        return fsr == null ? null :
                new FilmShowRoom(fsr.getFilmShowRoomId());
    }

    private FilmShowroomEntity from(FilmShowRoom fsr) {
        return fsr == null ? null :
                new FilmShowroomEntity(fsr.getFilmShowRoomId());
    }
}
