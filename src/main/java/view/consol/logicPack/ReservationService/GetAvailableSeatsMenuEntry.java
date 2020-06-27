package view.consol.logicPack.ReservationService;

import logic.ReservationService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.UserContext;

@RequiredArgsConstructor
public class GetAvailableSeatsMenuEntry implements InterfaceMenuEntry {

    private final ReservationService reservationService;

    @Override
    public void options(UserContext userContext) {
        reservationService.getAvailableSeats(userContext.getChosenSeans());
    }

    @Override
    public void printMenu() {

    }

    @Override
    public String menuEntryName() {
        return "Wyświetlanie dostępnych miejsc na seansie.";
    }
}
