package domain.movie;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import persistence.movie.MovieEntity;

import java.util.Set;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(source = "seansEntities", target = "seans")
    Movie movieEntityToMovie(MovieEntity movieEntity);

    @InheritInverseConfiguration(name = "movieEntityToMovie")
    MovieEntity movieToMovieEntity(Movie movie);

    Set<Movie> movieEntityToMovie(Set<MovieEntity> movieEntities);

    Set<MovieEntity> movieToMovieEntity(Set<Movie> movies);
}
