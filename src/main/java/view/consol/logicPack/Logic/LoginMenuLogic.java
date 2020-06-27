package view.consol.logicPack.Logic;

import view.consol.graphicsPack.StartMenu;
import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.Scanner;

public class LoginMenuLogic implements InterfaceMenuEntry {

    Scanner scanner = new Scanner(System.in);
    UserContext userContext = new UserContext();

    @Override
    public void options(UserContext userContext) {

        switch (userContext.getChoice()) {
            case "1":
                MenuFactory.getFullLine();
                MenuFactory.getInfoLine("Podaj swój adres email:", null, null, null);
                MenuFactory.getFullLine();

                String email = scanner.nextLine();


                break;
            case "2":
                new StartMenu().printMenu();
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
