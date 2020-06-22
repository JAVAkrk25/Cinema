package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class SeatEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;
    private int row;
    private int seatNumber;

    @ManyToOne
    private FilmShowRoomEntity filmShowRoomEntity;

    @OneToMany (mappedBy = "seatEntity")
    private Set<ReservationEntity> reservationEntities = new HashSet<>();

    public SeatEntity(int seatId, int row, int seatNumber, FilmShowRoomEntity filmShowRoomEntity) {
        this.seatId = seatId;
        this.row = row;
        this.seatNumber = seatNumber;
        this.filmShowRoomEntity = filmShowRoomEntity;
    }

}
