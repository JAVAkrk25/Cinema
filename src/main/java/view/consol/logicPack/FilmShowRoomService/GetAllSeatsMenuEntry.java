package view.consol.logicPack.FilmShowRoomService;

import logic.FilmShowRoomService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.MenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.Scanner;

@RequiredArgsConstructor
public class GetAllSeatsMenuEntry implements MenuEntry {

    private final FilmShowRoomService filmShowRoomService;
    UserContext userContext;

    @Override
    public void options() {
        Scanner scanner = new Scanner(System.in);
        MenuFactory.getTitleLine("Wyświetl wszystkie miejsca w sali kinowej.");
        MenuFactory.getTitleLine("Podaj indentyfikator sali kinowej:");
        MenuFactory.getEmptyLine();
        String element = scanner.nextLine();
        String[] split = element.split(" ");
        if (split.length == 1) {
            filmShowRoomService.getAllSeats(Integer.parseInt(split[0].trim()));
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
        return "Wyświetl wszystkie miejsca w sali kinowej.";
    }
}
