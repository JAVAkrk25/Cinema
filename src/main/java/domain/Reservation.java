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

    public Reservation(Seans seans, Client client, Seat seat) {
        this.seans = seans;
        this.client = client;
        this.seat = seat;
    }
}
