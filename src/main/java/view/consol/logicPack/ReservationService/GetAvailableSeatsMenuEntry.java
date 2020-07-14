package view.consol.logicPack.ReservationService;

import logic.ReservationService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.MenuEntry;
import view.consol.logicPack.UserContext;

@RequiredArgsConstructor
public class GetAvailableSeatsMenuEntry implements MenuEntry {

    private final ReservationService reservationService;
    UserContext userContext;

    @Override
    public void options() {

        reservationService.getAvailableSeats(userContext.getChosenSeans()).forEach(System.out::println);
    }

    @Override
    public void printMenu() {

    }

    @Override
    public String menuEntryName() {
        return "Wyświetlanie dostępnych miejsc na seansie.";
    }
}
