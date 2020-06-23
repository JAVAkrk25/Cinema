package persistence.filmShowRoom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import persistence.seans.SeansEntity;
import persistence.seat.SeatEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class FilmShowRoomEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmShowRoomId;

    @OneToMany(mappedBy = "filmShowroomEntity")
    private Set<SeansEntity> filmShowEntities;

    @OneToMany(mappedBy = "filmShowroomEntity")
    private Set<SeatEntity> seats;

    public FilmShowRoomEntity(int filmShowRoomId) {
        this.filmShowRoomId = filmShowRoomId;
    }
}
