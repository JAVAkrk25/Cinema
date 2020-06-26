package view.consol.logicPack.FilmShowRoomService;

import logic.FilmShowRoomService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.MenuFactory;

import java.util.Scanner;

@RequiredArgsConstructor
public class AddSeatsMenuEntry implements InterfaceMenuEntry {

    private final FilmShowRoomService filmShowRoomService;

    @Override
    public void options() {
        Scanner scanner = new Scanner(System.in);
        MenuFactory.getTitleLine("Dodaj siedzenie do sali kinowej:");
        MenuFactory.getTitleLine("Podaj numer rzędu, numer siedzenia, indentyfikator sali kinowej.");
        MenuFactory.getTitleLine("( Podawane dane rozdziel przecinkami. )");
        MenuFactory.getEmptyLine();
        String element = scanner.nextLine();
        String[] split = element.split(",");
        if (split.length == 3) {
            filmShowRoomService.addSeats(Integer.parseInt(split[0].trim()),
                    Integer.parseInt(split[1].trim()),
                    Integer.parseInt(split[2].trim()));
        } else {
            MenuFactory.getEmptyLine();
            MenuFactory.getTitleLine("Błędne dane.");
        }

    }

    @Override
    public String menuEntryName() {
        return "Dodaj siedzenie do sali kinowej.";
    }
}
