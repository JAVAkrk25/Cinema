package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    private String name;
    private String surname;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "clientEntity")
    private Set<ReservationEntity> reservationEntities = new HashSet<>();

    public ClientEntity(Integer clientId, String name, String surname, String email, String phone) {
        this.clientId = clientId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }
}
