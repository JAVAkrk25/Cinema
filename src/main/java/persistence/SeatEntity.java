package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import persistence.ReservationEntity;
import persistence.FilmShowRoomEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Seat")
public class SeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    @Column(name = "seat_row")
    private Integer row;
    private Integer seatNumber;

    @ManyToOne
    private FilmShowRoomEntity filmShowRoomEntity;

    @OneToMany (mappedBy = "seatEntity")
    private Set<ReservationEntity> reservationEntities = new HashSet<>();

    public SeatEntity( Integer row, Integer seatNumber, FilmShowRoomEntity filmShowRoomEntity) {
        this.row = row;
        this.seatNumber = seatNumber;
        this.filmShowRoomEntity = filmShowRoomEntity;
    }
}
