package persistence.client;

import domain.Client;


public interface ClientDAO {
    Client findById(int id);

    void save(Client client);

    void update(Client client);

    void delete(String clientId);

}
