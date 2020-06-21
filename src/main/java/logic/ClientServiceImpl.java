package logic;

import domain.Client;
import lombok.RequiredArgsConstructor;
import persistence.ClientDAO;


@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientDAO clientDAO;

    @Override
    public void addClient(int id, String name, String surname, String email, String phone) {
        Client client = new Client(id, name, surname, email, phone);
        clientDAO.save(client);
    }

    @Override
    public void delete(String clientId) {
        clientDAO.delete(clientId);
    }

}
