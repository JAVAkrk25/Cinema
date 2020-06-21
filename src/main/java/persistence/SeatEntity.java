package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class SeatEntity {

    @ManyToOne
    private FilmShowroomEntity filmShowroomEntity;

    @OneToMany (mappedBy = "seatEntity")
    private Set<ReservationEntity> reservationEntities = new HashSet<>();

}
