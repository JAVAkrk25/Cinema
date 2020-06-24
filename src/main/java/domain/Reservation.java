package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Reservation {
    private Integer reservationId;
    private Seans seans;
    private Client client;
    private Seat seat;
}
