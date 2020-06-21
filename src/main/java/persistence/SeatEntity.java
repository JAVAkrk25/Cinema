package persistence;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class SeatEntity {

    @ManyToOne
    private FilmShowroomEntity filmShowroomEntity;

}
