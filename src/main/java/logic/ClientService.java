package logic;


import domain.Client;
import persistence.ClientEntity;

public interface ClientService {
    void addClient(String name, String surname, String email, String phone);

    void delete(Integer clientId);

    Client findByEmail (String email);



}
