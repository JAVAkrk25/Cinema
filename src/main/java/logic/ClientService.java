package logic;


public interface ClientService {
    void addClient(String id, String name, String surname, String email, String phone);

    void delete(String clientId);



}
