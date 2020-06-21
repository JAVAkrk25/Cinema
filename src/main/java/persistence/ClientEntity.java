package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ClientEntity {
    @Id
    private String clientId;
    private String name;
    private String surname;
    private String email;
    private String phone;

    @OneToOne(mappedBy = "client")
    private Set<ClientEntity> clients = new HashSet<>();

    public ClientEntity(String clientId, String name, String surname, String email, String phone) {
        this.clientId = clientId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }
}
