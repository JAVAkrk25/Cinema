package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Reservation {
    private int reservationId;
    private Seans seans;
    private Client client;
    private Seat seat;
}
