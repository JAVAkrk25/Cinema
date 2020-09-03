package domain.seans;

import domain.filmShowRoom.FilmShowRoom;
import domain.movie.Movie;
import domain.reservation.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import persistence.reservation.ReservationEntity;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Seans {
    private Integer seansId;
    private LocalDateTime startTimeAndDate;
    private Movie movie;
    private FilmShowRoom filmShowRoom;
    private Set<Reservation> reservations;
}
