package persistence.seans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import persistence.reservation.ReservationEntity;
import persistence.filmShowRoom.FilmShowRoomEntity;
import persistence.movie.MovieEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class SeansEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmShowId;
    private LocalDateTime startTimeAndDate;

    @ManyToOne
    private MovieEntity movie;

    @ManyToOne
    private FilmShowRoomEntity filmShowRoomEntity;

    @OneToMany(mappedBy = "seansEntity")
    private Set<ReservationEntity> reservationEntity = new HashSet<>();

    public SeansEntity(int filmShowId, LocalDateTime startTimeAndDate, MovieEntity movie, FilmShowRoomEntity filmShowRoomEntity) {
        this.filmShowId = filmShowId;
        this.startTimeAndDate = startTimeAndDate;
        this.movie = movie;
        this.filmShowRoomEntity = filmShowRoomEntity;
    }
}
