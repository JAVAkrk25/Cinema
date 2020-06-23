package utils;

import domain.*;
import persistence.client.ClientEntity;
import persistence.filmShowRoom.FilmShowRoomEntity;
import persistence.movie.MovieEntity;
import persistence.seans.SeansEntity;
import persistence.seat.SeatEntity;

public class Mapper {
    private Mapper() {
    }

    public static Seat from(SeatEntity seatEntity) {
        return seatEntity == null ? null :
                new Seat(seatEntity.getSeatId(), seatEntity.getRow(), seatEntity.getSeatNumber(), from(seatEntity.getFilmShowRoomEntity()));
    }

    public static SeatEntity from(Seat seats) {
        return seats == null ? null :
                new SeatEntity(seats.getSeatId(), seats.getRow(), seats.getSeatNumber(), from(seats.getFilmShowRoom()));
    }

    public static Seans from(SeansEntity seansEntity) {
        return seansEntity == null ? null :
                new Seans(seansEntity.getFilmShowId(), seansEntity.getStartTimeAndDate(), from(seansEntity.getMovie()), from(seansEntity.getFilmShowRoomEntity()));
    }

    public static SeansEntity from(Seans seans) {
        return seans == null ? null :
                new SeansEntity(seans.getSeansId(), seans.getStartTimeAndDate(), from(seans.getMovie()), from(seans.getFilmShowRoom()));
    }

    public static Movie from(MovieEntity movieEntity) {
        return movieEntity == null ? null :
                new Movie(movieEntity.getMovieId(), movieEntity.getTitle(), movieEntity.getDirector(), movieEntity.getDuration());
    }

    public static MovieEntity from(Movie movie) {
        return movie == null ? null :
                new MovieEntity(movie.getMovieId(), movie.getTitle(), movie.getDirector(), movie.getDuration());
    }

    public static Client from(ClientEntity clientEntity) {
        return clientEntity == null ? null :
                new Client(clientEntity.getClientId(), clientEntity.getName(), clientEntity.getSurname(), clientEntity.getEmail(), clientEntity.getPhone());
    }

    public static ClientEntity from(Client client) {
        return client == null ? null :
                new ClientEntity(client.getClientId(), client.getName(), client.getSurname(), client.getEmail(), client.getPhone());
    }

    public static FilmShowRoom from(FilmShowRoomEntity fsr) {
        return fsr == null ? null :
                new FilmShowRoom(fsr.getFilmShowRoomId());
    }

    public static FilmShowRoomEntity from(FilmShowRoom fsr) {
        return fsr == null ? null :
                new FilmShowRoomEntity(fsr.getFilmShowRoomId());
    }
}
