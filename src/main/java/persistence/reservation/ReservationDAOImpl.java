package persistence.reservation;

import domain.Reservation;
import domain.Seans;
import domain.Seat;
import lombok.RequiredArgsConstructor;
import persistence.seat.SeatEntity;
import utils.Mapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ReservationDAOImpl implements ReservationDAO {

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

    @Override
    public Set<Seat> getBookedSeats(Seans seans) {
        EntityManager seanss = null;
        try {
            seanss = emf.createEntityManager();
            seanss.getTransaction().begin();
            TypedQuery<SeatEntity> query = seanss.createQuery("FROM SeatEntity s WHERE s.seansEntity.seansId =:seansId", SeatEntity.class);
            query.setParameter("seansId", seans.getSeansId());
            Set<Seat> result = query.getResultStream().map(Mapper::from).collect(Collectors.toSet());
            seanss.getTransaction().commit();
            return result;
        } finally {
            if (seanss != null) {
                seanss.close();
            }
        }
    }

    @Override
    public Set<Seat> getAvailableSeats(Seans seans) {
        return null;
    }
}
