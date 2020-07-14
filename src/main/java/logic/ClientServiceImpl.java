package logic;

import domain.Client;
import domain.ClientMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import persistence.ClientDAO;
import persistence.ClientEntity;

@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService, ClientMapper {

    private final ClientDAO clientDAO;

    @Override
    public void addClient(String name, String surname, String email, String phone, String login, String password) {
        ClientEntity clientEntity = ClientEntity.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .phone(phone)
                .login(login)
                .password(password)
                .build();
        clientDAO.save(clientEntity);
    }

    @Override
    public void delete(Integer clientId) {
        ClientEntity found = clientDAO.findById(clientId);
        if (found != null) {
            clientDAO.delete(found);
        }
    }

    @Override
    public Client findByLogin(String login) {
        ClientEntity clientEntity = clientDAO.findByLogin(login);
        return clientEntityToClient(clientEntity);
    }

    @Override
    public ClientEntity clientToClientEntity(Client client) {
        return null;
    }

    @Override
    public Client clientEntityToClient(ClientEntity clientEntity) {
        return null;
    }
}
