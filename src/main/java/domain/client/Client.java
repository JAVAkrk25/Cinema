package domain.client;

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
public class Client {
    private Integer clientId;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String login;
    private String password;
    private Set<Reservation> reservations;
}
