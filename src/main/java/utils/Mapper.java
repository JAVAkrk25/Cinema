package utils;

import domain.Seans;
import domain.Seat;
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

    private Seans from(SeansEntity seansEntity) {
        return seansEntity == null ? null :
                new Seans(seansEntity.getFilmShowId(), seansEntity.getStartTimeAndDate(), from(seansEntity.getMovie()), from(seansEntity.getFilmShowRoomEntity()));
    }

    private SeansEntity from(Seans seans) {
        return seans == null ? null :
                new SeansEntity(seans.getSeansId(), seans.getStartTimeAndDate(), from(seans.getMovie()), from(seans.getFilmShowRoom()));
    }


}
