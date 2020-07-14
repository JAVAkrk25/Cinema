package logic;


import domain.Client;

public interface ClientService {
    void addClient(String name, String surname, String email, String phone, String login, String password);

    void delete(Integer clientId);

    Client findByLogin(String login);

}
