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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;

    @ManyToOne
    private SeansEntity seansEntity;

    @ManyToOne
    private ClientEntity clientEntity;

    @ManyToOne
    private SeatEntity seatEntity;

    public ReservationEntity(SeansEntity seansEntity, ClientEntity clientEntity, SeatEntity seatEntity) {
        this.reservationId = reservationId;
        this.seansEntity = seansEntity;
        this.clientEntity = clientEntity;
        this.seatEntity = seatEntity;
    }
}
