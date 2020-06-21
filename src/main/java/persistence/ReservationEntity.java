package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ReservationEntity {


    @ManyToOne
    private ClientEntity clientEntity;

    @ManyToOne
    private FilmShowEntity filmShowEntity;

    @ManyToOne
    private SeatEntity seatEntity;



}
