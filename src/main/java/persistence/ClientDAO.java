package persistence;

import domain.Client;


public interface ClientDAO {
    void save(Client client);

    void update(Client client);

    void delete(String clientId);

}
