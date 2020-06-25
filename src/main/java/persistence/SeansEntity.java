package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import persistence.ReservationEntity;
import persistence.FilmShowRoomEntity;
import persistence.MovieEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Seans")
public class SeansEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seansId;
    private LocalDateTime startTimeAndDate;

    @ManyToOne
    private MovieEntity movie;

    @ManyToOne
    private FilmShowRoomEntity filmShowRoomEntity;

    @OneToMany(mappedBy = "seansEntity")
    private Set<ReservationEntity> reservationEntity = new HashSet<>();

    public SeansEntity(Integer seansId, LocalDateTime startTimeAndDate, MovieEntity movie, FilmShowRoomEntity filmShowRoomEntity) {
        this.seansId = seansId;
        this.startTimeAndDate = startTimeAndDate;
        this.movie = movie;
        this.filmShowRoomEntity = filmShowRoomEntity;
    }
}
