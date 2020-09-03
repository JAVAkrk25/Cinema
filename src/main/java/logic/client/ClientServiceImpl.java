package logic.client;

import domain.client.Client;
import domain.client.ClientMapper;
import lombok.RequiredArgsConstructor;
import persistence.client.ClientDAO;
import persistence.client.ClientEntity;

@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientDAO clientDAO;

    @Override
    public void addClient(String name, String surname, String email, String phone, String login, String password) {
        Client client = Client.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .phone(phone)
                .login(login)
                .password(password)
                .build();
        ClientEntity clientEntity = ClientMapper.INSTANCE.clientToClientEntity(client);
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
        return ClientMapper.INSTANCE.clientEntityToClient(clientEntity);
    }
}
