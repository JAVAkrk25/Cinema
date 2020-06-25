package destop;

import domain.Client;
import domain.FilmShowRoom;
import logic.*;
import persistence.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema");
        ClientDAO clientDAO = new ClientDAOImpl(emf);

        ClientService clientService = new ClientServiceImpl(clientDAO);
        clientService.addClient("Janina", "Nowak", "janina.nowak@jmail.pl", "999666666");
        clientService.addClient("Andrzej", "Mickiewicz", "andrzej.miki@jmail.pl", "666000666");
        clientService.addClient("Juliusz", "Słowacki", "juliusz.slowacki@jmail.pl", "666666666");

        SeatDAO seatDAO = new SeatDAOImpl(emf);

        FilmShowRoomDAO filmShowRoomDAO = new FilmShowRoomImp(emf);
        FilmShowRoomService filmShowRoomService = new FilmShowRoomServiceImpl(filmShowRoomDAO, seatDAO);
        filmShowRoomService.addFilmShowRoom();
        filmShowRoomService.addFilmShowRoom();
        filmShowRoomService.addFilmShowRoom();

        SeatService seatService = new SeatServiceImpl(seatDAO, filmShowRoomDAO);
        seatService.addSeats(1, 1, 1);
        seatService.addSeats(1, 2, 1);
        seatService.addSeats(1, 3, 1);
        seatService.addSeats(1, 4, 1);
        seatService.addSeats(1, 5, 1);

        System.out.println(filmShowRoomService.getAllSeats(1));

    }
}
