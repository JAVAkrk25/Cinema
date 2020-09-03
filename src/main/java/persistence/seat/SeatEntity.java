package persistence.seat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import persistence.filmShowRoom.FilmShowRoomEntity;
import persistence.reservation.ReservationEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder

@NamedQueries({
        @NamedQuery(name = "SeatEntity.getAllSeatsByFilmShowRoomId",
                query = "SELECT s FROM SeatEntity s WHERE s.filmShowRoomEntity.filmShowRoomId = :filmShowRoomId"),
        @NamedQuery(name = "SeatEntity.getAllSeatsByFilmShowRoomName",
                query = "SELECT s FROM SeatEntity s WHERE s.filmShowRoomEntity.filmShowRoomName = :filmShowRoomName")
})

@Table(name = "Seat")
public class SeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;
    private Integer rowNumber;
    private Integer seatNumber;

    @ManyToOne
    private FilmShowRoomEntity filmShowRoomEntity;

    @OneToMany(mappedBy = "seatEntity")
    private Set<ReservationEntity> reservationEntities;
}
