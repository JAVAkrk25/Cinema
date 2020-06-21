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
    private FilmShowEntity filmShowEntity;

    @ManyToOne
    private SeatEntity seatEntity;

    public ReservationEntity(int reservationId, ClientEntity clientEntity, FilmShowEntity filmShowEntity, SeatEntity seatEntity) {
        this.reservationId = reservationId;
        this.clientEntity = clientEntity;
        this.filmShowEntity = filmShowEntity;
        this.seatEntity = seatEntity;
    }
}
