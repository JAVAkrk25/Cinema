package logic;

import domain.Seans;
import domain.Seat;

import java.util.Set;

public interface ReservationService {

    void bookSeat(Integer clientId, Integer seansId, Integer seatId);

    Set<Seat> getAvailableSeats(Seans seans);
    //wyciagnac info o wszytkich dostepnych w danej sali
    //wyciagnac krzesła z rezerwacji na dany seans i zwrocic roznice tych zbiorow

    Set<Seat> getBookedSeats(Seans seans);
    // wyciagnac krzesla z rezerwacji na dany seans

}
