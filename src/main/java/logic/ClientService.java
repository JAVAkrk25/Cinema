package logic;


public interface ClientService {
    void addClient(String name, String surname, String email, String phone);

    void delete(Integer clientId);

}
