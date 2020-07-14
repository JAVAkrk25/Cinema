package persistence;

import lombok.Builder;
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
@Builder

@NamedQuery(name = "SeansEntity.getAllSeans",
        query = "SELECT s FROM SeansEntity s WHERE s.movie.movieId =:movieId")

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
}
