package view.consol.logicPack.MovieService;

import logic.movie.MovieService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.MenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.Scanner;

@RequiredArgsConstructor
public class GetAllMoviesMenuEntry implements MenuEntry {

    private final MovieService movieService;
    UserContext userContext;

    @Override
    public void options() {
        Scanner scanner = new Scanner(System.in);
        MenuFactory.getTitleLine("Wyświetl wszystkie filmy.");
        MenuFactory.getEmptyLine();
        movieService.getAllMovies();
    }

    @Override
    public void printMenu() {

    }

    @Override
    public String menuEntryName() {
        return "Wyświetl wszystkie filmy.";
    }
}
