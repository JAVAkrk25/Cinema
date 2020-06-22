package persistence;

import domain.Movie;
import domain.Seans;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
public class SeansDAOImpl implements SeansDAO {

    private final EntityManagerFactory emf;


    @Override
    public void save(Seans seans) {
        EntityManager seanses = null;
        try {
            seanses = emf.createEntityManager();
            seanses.getTransaction().begin();
            seanses.persist(from(seans));
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

    private Seans from(SeansEntity seansEntity) {
        return seansEntity == null ? null :
                new Seans(seansEntity.getFilmShowId(), seansEntity.getStartTimeAndDate(),from(seansEntity.getMovie())
    }

    private SeansEntity from(Seans seans) {
        return seans == null ? null :
                new SeansEntity(seans.getSeansId(), seans.getStartTimeAndDate(), new Movie(seans.getMovie(), )ans.getMovie(), seans.getFilmShowRoom());

    }
}

