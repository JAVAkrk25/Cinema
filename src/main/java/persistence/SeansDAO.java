package persistence;

import domain.Movie;
import domain.Seans;

import java.util.Set;

public interface SeansDAO extends EntityDAO<SeansEntity> {

    Set<SeansEntity> getAllSeans(MovieEntity movie);
}
