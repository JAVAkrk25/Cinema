package persistence;

import domain.Client;
import domain.Movie;

import java.util.Set;

public interface ClientDAO {
    void save(Client client);

    void update(Client client);

    void delete(String clientId);

    Set<Movie> findMovie(String movieId);


}
