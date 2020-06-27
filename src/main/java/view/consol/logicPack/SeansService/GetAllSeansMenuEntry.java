package view.consol.logicPack.SeansService;

import domain.Movie;
import logic.SeansService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.Scanner;

@RequiredArgsConstructor
public class GetAllSeansMenuEntry implements InterfaceMenuEntry {
    private final SeansService seansService;

    @Override
    public void options(UserContext userContext) {

        seansService.getAllSeans(userContext.getChosenMovie());
    }

    @Override
    public void printMenu() {


    }

    @Override
    public String menuEntryName() {
        return "Wyświetl wsystkie seanse";
    }
}
