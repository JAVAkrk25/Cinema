package view.consol.logicPack.ReservationService;


import logic.reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.MenuEntry;
import view.consol.logicPack.UserContext;

@RequiredArgsConstructor
public class GetBookedSeats implements MenuEntry {

    private final ReservationService reservationService;
    UserContext userContext;

    @Override
    public void options() {
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
