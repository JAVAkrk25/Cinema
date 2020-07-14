package view.consol.logicPack.SeansService;

import logic.SeansService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.MenuEntry;
import view.consol.logicPack.UserContext;

@RequiredArgsConstructor
public class GetAllSeansMenuEntry implements MenuEntry {
    private final SeansService seansService;
    UserContext userContext;

    @Override
    public void options() {

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
