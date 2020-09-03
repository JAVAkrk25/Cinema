package persistence.seans;

import persistence.EntityDAO;
import persistence.movie.MovieEntity;

import java.util.Set;

public interface SeansDAO extends EntityDAO<SeansEntity> {

    Set<SeansEntity> getAllSeans(MovieEntity movie);
}
