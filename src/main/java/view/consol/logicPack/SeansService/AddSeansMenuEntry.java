package view.consol.logicPack.SeansService;

import logic.FilmShowRoomService;
import logic.MovieService;
import logic.SeansService;
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
        MenuFactory.getTitleLine("Podaj datę i godzinę w formacie YYYY-MM-DDTHH:mm:ss, nazwę filmu, numer sali (1, 2 lub 3)");
        MenuFactory.getTitleLine("Podawane dane rozdziel przecinkami");
        MenuFactory.getEmptyLine();
        String element = scanner.nextLine();
        String[] split = element.split(",");
        if (split.length == 3){
            seansService.addSeans(LocalDateTime.parse(split[0].trim()), movieService.findByMovieTitle(split[1].trim()), filmShowRoomService.findById(Integer.parseInt(split[2].trim())));
        }else {
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
