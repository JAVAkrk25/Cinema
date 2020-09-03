package view.consol.logicPack.SeansService;

import logic.filmShowRoom.FilmShowRoomService;
import logic.movie.MovieService;
import logic.seans.SeansService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.MenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.time.LocalDateTime;
import java.util.Scanner;

@RequiredArgsConstructor
public class AddSeansMenuEntry implements MenuEntry {

    private final SeansService seansService;
    private final MovieService movieService;
    private final FilmShowRoomService filmShowRoomService;
    UserContext userContext;


    @Override
    public void options() {
        Scanner scanner = new Scanner(System.in);
        MenuFactory.getTitleLine("Dodaj seans");
        MenuFactory.getTitleLine("Podaj nazwę filmu, numer sali (1, 2 lub 3) oraz " +
                "datę i godzinę rozpoczęcia w formacie YYYY-MM-DDTHH:mm:ss");
        MenuFactory.getTitleLine("Podawane dane rozdziel przecinkami");
        MenuFactory.getEmptyLine();
        String element = scanner.nextLine();
        String[] split = element.split(",");
        if (split.length == 3) {
            seansService.addSeans(
                    movieService.findByTitle(split[1].trim()),
                    filmShowRoomService.getFilmShowRoom(Integer.parseInt(split[2].trim())),
                    LocalDateTime.parse(split[0].trim()));
        } else {
            MenuFactory.getEmptyLine();
            MenuFactory.getTitleLine("Błędne dane.");
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
