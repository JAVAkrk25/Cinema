package domain.filmShowRoom;

import domain.seans.Seans;
import domain.seat.Seat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class
FilmShowRoom {
    private Integer filmShowRoomId;
    private String filmShowRoomName;
    private Set<Seans> seans;
    private Set<Seat> seats;
}
