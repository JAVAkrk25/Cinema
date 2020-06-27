package persistence;

public interface MovieDAO extends EntityDAO<MovieEntity> {

    MovieEntity findByMovieTitle(String name);


}
