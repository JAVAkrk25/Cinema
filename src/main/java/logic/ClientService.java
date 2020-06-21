package logic;


public interface ClientService {
    void addClient(int id, String name, String surname, String email, String phone);

    void delete(String clientId);

}
