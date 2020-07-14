package persistence;

import lombok.Builder;
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
@Builder

@NamedQuery(name = "SeatEntity.getAllSeats",
        query = "SELECT s FROM SeatEntity s WHERE s.filmShowRoomEntity.filmShowRoomId = :filmShowRoomId")

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

    @OneToMany(mappedBy = "seatEntity")
    private Set<ReservationEntity> reservationEntities = new HashSet<>();
}
