package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private FilmShowroomEntity filmShowroomEntity;

    @OneToMany(mappedBy = "seansEntity")
    private Set<ReservationEntity> reservationEntity = new HashSet<>();

    public SeansEntity(int filmShowId, LocalDateTime startTimeAndDate, MovieEntity movie, FilmShowroomEntity filmShowroomEntity) {
        this.filmShowId = filmShowId;
        this.startTimeAndDate = startTimeAndDate;
        this.movie = movie;
        this.filmShowroomEntity = filmShowroomEntity;
    }
}
