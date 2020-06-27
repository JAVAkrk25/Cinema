package destop;

import domain.FilmShowRoom;
import domain.Movie;
import logic.*;
import persistence.*;
import view.consol.logicPack.ClientService.AddClientMenuEntry;
import view.consol.logicPack.FilmShowRoomService.AddSeatsMenuEntry;
import view.consol.logicPack.MovieService.AddMovieMenuEntry;
import view.consol.logicPack.SeansService.AddSeansMenuEntry;
import view.consol.logicPack.SeansService.GetAllSeansMenuEntry;
import view.consol.logicPack.UserContext;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Optional;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SqtyJ7nmGK");

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


        filmShowRoomService.addSeats(1, 1, 1);
        filmShowRoomService.addSeats(1, 2, 1);
        filmShowRoomService.addSeats(1, 3, 1);
        filmShowRoomService.addSeats(1, 4, 1);
        filmShowRoomService.addSeats(1, 5, 1);


        MovieDAO movieDAO = new MovieDAOImpl(emf);
        MovieService movieService = new MovieServiceImpl(movieDAO);
        movieService.addMovie("Krzyżacy", "Aleksander Ford", "Zbyszko z Bogdańca (Mieczysław Kalenik) jako ostatni z rodu powraca wraz ze swoim " +
                "stryjem Maćkiem (Aleksander Fogiel) ze zwycięskiej wyprawy wojennej. Podczas postoju w karczmie poznaje " +
                "piękną Danuśkę (Grażyna Staniszewska) i urzeczony historią dziewczyny ślubuje jej dostarczenie kilku czubów " +
                "krzyżackich. Pechowo jednak jako pierwszego atakuje posła krzyżackiego. Zostaje za to skazany na śmierć. " +
                "Podczas szukania ratunku dla bratanka stryj chłopaka zostaje ciężko ranny. Ostatnią nadzieją dla młodzieńca " +
                "okazuje się Danuśka, która nakrywając go nałęczką, ratuje Zbyszka przed śmiercią. Kiedy dziewczyna zostaje " +
                "porwana, rycerz robi wszystko, aby ją uratować. Pomaga mu w tym jego stryj oraz wierny giermek Hlawa " +
                "(Mieczysław Stoor).");
        movieService.addMovie("Seksmisja", "Juliusz Machulski", "W roku 2044 zostają odhibernowani dwaj " +
                "ostatni przedstawiciele płci męskiej, wprowadzając chaos do idealnego świata rządzonego przez Ligę Kobiet.");
        movieService.addMovie("Kochankowie z księżyca", "Wes Anderson", "Lata sześćdziesiąte XX wieku. " +
                "Nastoletni i zakochani w sobie Sam i Suzy postanawiają uciec z domu. Poszukiwania prowadzi kapitan Sharp, " +
                "pomagają mu rodzice dziewczynki.");

        SeansDAO seansDAO = new SeansDAOImpl(emf);
        SeansService seansService = new SeansServiceImpl(seansDAO);
        Optional<Movie> krzyżacy = movieService.getAllMovies().stream().filter(movie -> movie.getTitle().equals("Krzyżacy")).findAny();

        FilmShowRoom filmShowRoom = filmShowRoomService.getFilmShowRoom(1);

        krzyżacy.ifPresent(movie -> seansService.addSeans(LocalDateTime.parse("2020-10-11T11:11:00"), movie, filmShowRoom));


        AddClientMenuEntry addClientMenuEntry = new AddClientMenuEntry(clientService);
        addClientMenuEntry.options(new UserContext());



        AddMovieMenuEntry addMovieMenuEntry = new AddMovieMenuEntry(movieService);
        addMovieMenuEntry.options(new UserContext());

        AddSeatsMenuEntry addSeatsMenuEntry = new AddSeatsMenuEntry(filmShowRoomService);
        addSeatsMenuEntry.options(new UserContext());



    }
}

