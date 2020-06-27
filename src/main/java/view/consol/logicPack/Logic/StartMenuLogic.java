package view.consol.logicPack.Logic;


import view.consol.graphicsPack.LoginMenu;

import domain.FilmShowRoom;
import domain.Movie;
import logic.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import persistence.*;
import view.consol.logicPack.FilmShowRoomService.AddSeatsMenuEntry;

import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.MovieService.AddMovieMenuEntry;
import view.consol.logicPack.ReservationService.BookSeatMenuEntry;
import view.consol.logicPack.SeansService.AddSeansMenuEntry;
import view.consol.logicPack.UserContext;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

public class StartMenuLogic implements InterfaceMenuEntry {

    Scanner scanner = new Scanner(System.in);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SqtyJ7nmGK");

    ClientDAO clientDAO = new ClientDAOImpl(emf);
    ClientService clientService = new ClientServiceImpl(clientDAO);

    SeatDAO seatDAO = new SeatDAOImpl(emf);
    FilmShowRoomDAO filmShowRoomDAO = new FilmShowRoomImp(emf);
    FilmShowRoomService filmShowRoomService = new FilmShowRoomServiceImpl(filmShowRoomDAO, seatDAO);

    MovieDAO movieDAO = new MovieDAOImpl(emf);
    MovieService movieService = new MovieServiceImpl(movieDAO);

    SeansDAO seansDAO = new SeansDAOImpl(emf);
    SeansService seansService = new SeansServiceImpl(seansDAO);

    ReservationDAO reservationDAO = new ReservationDAOImpl(emf,filmShowRoomDAO);
    ReservationService reservationService = new ReservationServiceImpl(reservationDAO, clientDAO, seansDAO, seatDAO);

    Optional<Movie> krzyżacy = movieService.getAllMovies().stream().filter(movie -> movie.getTitle().equals("Krzyżacy")).findAny();

    FilmShowRoom filmShowRoom = filmShowRoomService.getFilmShowRoom(1);

//        krzyżacy.ifPresent(movie -> seansService.addSeans(LocalDateTime.parse("2020-10-11T11:11:00"), movie, filmShowRoom));


    @Override
    public void options(UserContext userContext) {
        switch (userContext.getChoice()) {
            case "1":
                new LoginMenu().printMenu();
                break;
            case "2":
                break;
            case "3":
                AddMovieMenuEntry addMovieMenuEntry = new AddMovieMenuEntry(movieService);
                addMovieMenuEntry.options(new UserContext());
                break;
            case "4":
                AddSeansMenuEntry addSeansMenuEntry = new AddSeansMenuEntry(seansService, movieService, filmShowRoomService);
                addSeansMenuEntry.options(new UserContext());
                break;
            case "5":
                AddSeatsMenuEntry addSeatsMenuEntry = new AddSeatsMenuEntry(filmShowRoomService);
                addSeatsMenuEntry.options(new UserContext());
                break;
            case "6":
                BookSeatMenuEntry bookSeatMenuEntry = new BookSeatMenuEntry(reservationService);
                bookSeatMenuEntry.options(new UserContext());
                break;
            case "7":
                System.exit(0);
                break;
            default:
                MenuFactory.getFullLine();
                MenuFactory.getInfoLine("Została wybrana błędna opcja.", null, null, null);
                MenuFactory.getInfoLine("Wybierz ponownie:", null, null, null);
                MenuFactory.getFullLine();
        }
    }

    @Override
    public void printMenu() {

    }

    @Override
    public String menuEntryName() {
        return null;
    }
}
