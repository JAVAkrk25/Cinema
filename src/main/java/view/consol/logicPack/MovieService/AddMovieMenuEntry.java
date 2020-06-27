package view.consol.logicPack.MovieService;

import logic.MovieService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.Scanner;

@RequiredArgsConstructor
public class AddMovieMenuEntry implements InterfaceMenuEntry {

    private final MovieService movieService;

    @Override
    public void options(UserContext userContext) {
        Scanner scanner = new Scanner(System.in);
        MenuFactory.getTitleLine("Dodaj film.");
        MenuFactory.getTitleLine("Podaj tytuł, reżysera, opis:");
        MenuFactory.getTitleLine("( Każdą z danych zatwierdź osobno. )");
        MenuFactory.getEmptyLine();
        String element1 = scanner.nextLine();
        String element2 = scanner.nextLine();
        String element3 = scanner.nextLine();
        if (element1.length() > 0) {
            movieService.addMovie(element1, element2, element3);
        } else {
            MenuFactory.getEmptyLine();
            MenuFactory.getTitleLine("Błędne dane.");
        }
    }

    @Override
    public String menuEntryName() {
        return "Dodaj film.";
    }
}
