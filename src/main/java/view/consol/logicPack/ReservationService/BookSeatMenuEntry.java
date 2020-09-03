package view.consol.logicPack.ReservationService;

import logic.reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.MenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.Scanner;

@RequiredArgsConstructor
public class BookSeatMenuEntry implements MenuEntry {

    private final ReservationService reservationService;
    UserContext userContext;

    @Override
    public void options() {
        Scanner scanner = new Scanner(System.in);
        MenuFactory.getTitleLine("Zarezerwuj miejsce.");
        MenuFactory.getTitleLine("Podaj identyfikator klienta, identyfikator seansu, identyfikator siedzenia:");
        MenuFactory.getTitleLine("( Podawane dane rozdziel przecinkami. )");
        MenuFactory.getEmptyLine();
        String element = scanner.nextLine();
        String[] split = element.split(",");
        if (split.length == 3) {
            reservationService.bookSeat(Integer.parseInt(split[0].trim()),
                    Integer.parseInt(split[1].trim()),
                    Integer.parseInt(split[2].trim()));
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
        return "Zarezerwuj miejsce.";
    }
}
