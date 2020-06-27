package view.consol.logicPack.Logic;

import view.consol.graphicsPack.LoginMenu;
import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.Scanner;

public class StartMenuLogic implements InterfaceMenuEntry {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void options(UserContext userContext) {
        switch (userContext.getChoice()) {
            case "1":
                new LoginMenu().printMenu();
                break;
            case "2":
                break;
            case "3":
                System.exit(0);
                break;
            default:
                MenuFactory.getFullLine();
                MenuFactory.getInfoLine("Została wybrana błędna opcja.", null, null, null);
                MenuFactory.getInfoLine("Wybierz ponownie:", null, null, null);
                MenuFactory.getFullLine();
        }
    }

    @Override
    public void printMenu() {

    }

    @Override
    public String menuEntryName() {
        return null;
    }
}
