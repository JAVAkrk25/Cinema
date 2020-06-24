package persistence.reservation;

import domain.Reservation;
import lombok.RequiredArgsConstructor;
import utils.Mapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
public class ReservationDAOImpl implements ReservationDAO{

    private final EntityManagerFactory emf;

    @Override
    public void save(Reservation reservation) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(Mapper.from(reservation));
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void update(Reservation reservation) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(Mapper.from(reservation));
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void delete(String reservationId) {
        EntityManager reservation = null;
        try {
            reservation = emf.createEntityManager();
            reservation.getTransaction().begin();
            ReservationEntity employeeEntity = reservation.find(ReservationEntity.class, reservationId);
            if (employeeEntity != null) {
                reservation.remove(employeeEntity);
            }
            reservation.getTransaction().commit();
        } finally {
            if (reservation != null) {
                reservation.close();
            }
        }
    }
}
