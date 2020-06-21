package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Reservation {
    private String reservationId;
    private FilmShow filmShow;
    private Client client;
    private Seat seat;
}
