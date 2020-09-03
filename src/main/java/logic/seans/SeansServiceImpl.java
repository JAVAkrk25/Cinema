package logic.seans;

import domain.filmShowRoom.FilmShowRoom;
import domain.movie.Movie;
import domain.movie.MovieMapper;
import domain.seans.Seans;
import domain.seans.SeansMapper;
import lombok.RequiredArgsConstructor;
import persistence.seans.SeansDAO;
import persistence.seans.SeansEntity;

import java.time.LocalDateTime;
import java.util.Set;

@RequiredArgsConstructor
public class SeansServiceImpl implements SeansService {

    private final SeansDAO seansDAO;

    @Override
    public void addSeans(Movie movie, FilmShowRoom filmShowRoom, LocalDateTime startTimeAndDate) {
        Seans seans = Seans.builder()
                .movie(movie)
                .filmShowRoom(filmShowRoom)
                .startTimeAndDate(startTimeAndDate)
                .build();
        seansDAO.save(SeansMapper.INSTANCE.seansToSeansEntity(seans));
    }

    @Override
    public Set<Seans> getAllSeans(Movie movie) {
        Set<SeansEntity> allSeans = seansDAO.getAllSeans(MovieMapper.INSTANCE.movieToMovieEntity(movie));
        Set<Seans> seans = SeansMapper.INSTANCE.seansEntityToSeans(allSeans);
        return seans;
    }
}
