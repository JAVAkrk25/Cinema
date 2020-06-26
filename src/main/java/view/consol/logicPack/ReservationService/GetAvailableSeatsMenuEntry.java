package view.consol.logicPack.ReservationService;

import domain.Seans;
import logic.ReservationService;
import logic.SeansService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.MenuFactory;

import java.util.Scanner;

@RequiredArgsConstructor
public class GetAvailableSeatsMenuEntry implements InterfaceMenuEntry {

    private final ReservationService reservationService;

    @Override
    public void options() {
        reservationService.getAvailableSeats(new Seans());
    }

    @Override
    public String menuEntryName() {
        return "Wyświetlanie dostępnych miejsc na seansie.";
    }
}
