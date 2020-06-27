package view.consol.logicPack.ReservationService;


import logic.ReservationService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.UserContext;

@RequiredArgsConstructor
public class GetBookedSeats implements InterfaceMenuEntry {

    private final ReservationService reservationService;

    @Override
    public void options(UserContext userContext) {
        reservationService.getBookedSeats(userContext.getChosenSeans()).forEach(System.out::println);
    }

    @Override
    public void printMenu() {

    }

    @Override
    public String menuEntryName() {
        return "Wyświetlanie zarezerwowanych miejsc na seansie";
    }
}
