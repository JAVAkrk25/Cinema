package persistence.client;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import persistence.reservation.ReservationEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String login;
    private String password;

    @OneToMany(mappedBy = "clientEntity")
    private Set<ReservationEntity> reservationEntities;
}
