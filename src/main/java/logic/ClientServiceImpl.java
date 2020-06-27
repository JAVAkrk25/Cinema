package logic;

import domain.Client;
import lombok.RequiredArgsConstructor;
import persistence.ClientDAO;
import persistence.ClientEntity;
import utils.Mapper;


@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientDAO clientDAO;

    @Override
    public void addClient(String name, String surname, String email, String phone) {
        Client client = new Client(name, surname, email, phone);
        clientDAO.save(Mapper.from(client));
    }

    @Override
    public void delete(Integer clientId) {
        ClientEntity found = clientDAO.findById(clientId);
        if (found != null) {
            clientDAO.delete(found);
        }
    }
}
