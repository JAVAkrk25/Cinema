package logic;

import domain.Movie;

import java.util.Set;

public interface ClientService {
    void addClient(String id, String name, String surname, String email, String phone);

    void delete(String clientId);

    Set<Movie> chooseMovieName(String movieId);

}
