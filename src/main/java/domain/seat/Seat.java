package domain.seat;

import domain.filmShowRoom.FilmShowRoom;
import domain.reservation.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Seat {
    private Integer seatId;
    private int rowNumber;
    private int seatNumber;
    private FilmShowRoom filmShowRoom;
    private Set<Reservation> reservations;
}
