package view.consol.logicPack.MovieService;

import logic.MovieService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.Scanner;

@RequiredArgsConstructor
public class GetAllMoviesMenuEntry implements InterfaceMenuEntry {

    private final MovieService movieService;

    @Override
    public void options(UserContext userContext) {
        Scanner scanner = new Scanner(System.in);
        MenuFactory.getTitleLine("Wyświetl wszystkie filmy.");
        MenuFactory.getEmptyLine();
        movieService.getAllMovies();
    }

    @Override
    public String menuEntryName() {
        return "Wyświetl wszystkie filmy.";
    }
}
