package utils;

import domain.*;
import persistence.ClientEntity;
import persistence.FilmShowRoomEntity;
import persistence.MovieEntity;
import persistence.ReservationEntity;
import persistence.SeansEntity;
import persistence.SeatEntity;

public class Mapper {
    private Mapper() {
    }

    public static Seat from(SeatEntity seatEntity) {
        return seatEntity == null ? null :
                new Seat(seatEntity.getSeatId(), seatEntity.getRow(), seatEntity.getSeatNumber(), from(seatEntity.getFilmShowRoomEntity()));
    }

    public static SeatEntity from(Seat seats) {
        return seats == null ? null :
                new SeatEntity(seats.getRow(), seats.getSeatNumber(), from(seats.getFilmShowRoom()));
    }

    public static Seans from(SeansEntity seansEntity) {
        return seansEntity == null ? null :
                new Seans(seansEntity.getSeansId(), seansEntity.getStartTimeAndDate(), from(seansEntity.getMovie()), from(seansEntity.getFilmShowRoomEntity()));
    }

    public static SeansEntity from(Seans seans) {
        return seans == null ? null :
                new SeansEntity(seans.getSeansId(), seans.getStartTimeAndDate(), from(seans.getMovie()), from(seans.getFilmShowRoom()));
    }

    public static Movie from(MovieEntity movieEntity) {
        return movieEntity == null ? null :
                new Movie(movieEntity.getMovieId(), movieEntity.getTitle(), movieEntity.getDirector(), movieEntity.getDescription());
    }

    public static MovieEntity from(Movie movie) {
        return movie == null ? null :
                new MovieEntity(movie.getMovieId(),movie.getTitle(), movie.getDirector(), movie.getDescription());
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

    public static Reservation from(ReservationEntity reservationEntity) {
        return reservationEntity == null ? null :
                new Reservation(reservationEntity.getReservationId(), from(reservationEntity.getSeansEntity()), from(reservationEntity.getClientEntity()), from(reservationEntity.getSeatEntity()));
    }

    public static ReservationEntity from(Reservation reservation) {
        return reservation == null ? null :
                new ReservationEntity(from(reservation.getSeans()), from(reservation.getClient()), from(reservation.getSeat()));
    }

}
