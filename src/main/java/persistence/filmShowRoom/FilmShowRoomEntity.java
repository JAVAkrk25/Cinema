package persistence.filmShowRoom;

import lombok.Builder;
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
@Builder

@NamedQuery(name = "FilmShowRoom.findByName",
        query = "SELECT f FROM FilmShowRoomEntity f WHERE f.filmsShowRoomName = :filmShowRoomName")

@Table(name = "FilmShowRoom")
public class FilmShowRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmShowRoomId;
    private String filmShowRoomName;

    @OneToMany(mappedBy = "filmShowRoomEntity")
    private Set<SeansEntity> seansEntities;

    @OneToMany(mappedBy = "filmShowRoomEntity")
    private Set<SeatEntity> seatEntities;
}
