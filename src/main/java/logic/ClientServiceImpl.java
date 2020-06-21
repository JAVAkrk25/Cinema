package logic;

import domain.Client;
import domain.Movie;
import lombok.RequiredArgsConstructor;
import persistence.ClientDAO;

import java.util.Set;

@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientDAO clientDAO;

    @Override
    public void addClient(String id, String name, String surname, String email, String phone) {
        Client client = new Client(id, name, surname, email, phone);
        clientDAO.save(client);
    }

    @Override
    public void delete(String clientId) {
        clientDAO.delete(clientId);
    }

    @Override
    public Set<Movie> chooseMovieName(String movieId) {
        return clientDAO.findMovie(movieId);
    }

}
