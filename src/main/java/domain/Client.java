package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Client {
    private String clientId;
    private String name;
    private String surname;
    private String email;
    private String phone;
}
