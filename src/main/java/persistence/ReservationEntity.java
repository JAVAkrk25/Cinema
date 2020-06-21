package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ReservationEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;

    @ManyToOne
    private ClientEntity clientEntity;

    @ManyToOne
    private SeansEntity seansEntity;

    @ManyToOne
    private SeatEntity seatEntity;

    public ReservationEntity(int reservationId, ClientEntity clientEntity, SeansEntity seansEntity, SeatEntity seatEntity) {
        this.reservationId = reservationId;
        this.clientEntity = clientEntity;
        this.seansEntity = seansEntity;
        this.seatEntity = seatEntity;
    }
}
