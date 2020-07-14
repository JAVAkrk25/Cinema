package persistence;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder

@NamedQuery(name = "Reservation.SelectBookedSeatBySeans",
        query = "SELECT r.seatEntity FROM ReservationEntity r WHERE r.seansEntity = :seansEntity")

@Table(name = "Reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;

    @ManyToOne
    private SeansEntity seansEntity;

    @ManyToOne
    private ClientEntity clientEntity;

    @ManyToOne
    private SeatEntity seatEntity;
}
