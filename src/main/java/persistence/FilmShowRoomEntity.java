package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "FilmShowroom")
public class FilmShowRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmShowRoomId;

    @OneToMany(mappedBy = "filmShowRoomEntity")
    private Set<SeansEntity> seansEntity;

    @OneToMany(mappedBy = "filmShowRoomEntity")
    private Set<SeatEntity> seats;

      public FilmShowRoomEntity(Integer filmShowRoomId) {
        this.filmShowRoomId = filmShowRoomId;
    }
}
