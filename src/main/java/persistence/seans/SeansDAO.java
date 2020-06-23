package persistence.seans;

import domain.Movie;
import domain.Seans;

import java.util.Set;

public interface SeansDAO {
    void save (Seans seans);

    void delate (Seans seansId);

    Set<Seans> getAllSeans(Movie movie);
}
