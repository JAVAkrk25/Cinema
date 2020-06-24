package persistence.reservation;

import domain.Client;
import domain.Seans;
import domain.Seat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import persistence.client.ClientEntity;
import persistence.seans.SeansEntity;
import persistence.seat.SeatEntity;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;

    @ManyToOne
    private SeansEntity seansEntity;

    @ManyToOne
    private ClientEntity clientEntity;

    @ManyToOne
    private SeatEntity seatEntity;

    public ReservationEntity(int reservationId, SeansEntity seansEntity, ClientEntity clientEntity, SeatEntity seatEntity) {
        this.reservationId = reservationId;
        this.seansEntity = seansEntity;
        this.clientEntity = clientEntity;
        this.seatEntity = seatEntity;
    }
}
