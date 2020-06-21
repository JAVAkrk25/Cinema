package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class FilmShowroomEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmShowRoomId;

    @OneToMany(mappedBy = "filmShowroomEntity")
    private Set<FilmShowEntity> filmShowEntities;

    @OneToMany(mappedBy = "filmShowroomEntity")
    private Set<SeatEntity> seats;

    public FilmShowroomEntity(int filmShowRoomId) {
        this.filmShowRoomId = filmShowRoomId;
    }
}
