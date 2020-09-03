package domain.reservation;

import domain.seans.Seans;
import domain.seat.Seat;
import domain.client.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Reservation {
    private Integer reservationId;
    private Seans seans;
    private Client client;
    private Seat seat;
}
