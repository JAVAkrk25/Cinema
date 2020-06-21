package persistence;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ReservationEntity {


    @ManyToOne
    private ClientEntity clientEntity;

    @ManyToOne
    private FilmShowEntity filmShowEntity;

    @ManyToOne
    private SeatEntity seatEntity;

}
