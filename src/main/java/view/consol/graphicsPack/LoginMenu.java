package view.consol.graphicsPack;

import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.Logic.LoginMenuLogic;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.Scanner;

public class LoginMenu implements InterfaceMenuEntry {

    @Override
    public void options(UserContext userContext) {

    }

    @Override
    public void printMenu() {

        Scanner scanner = new Scanner(System.in);
        UserContext userContext = new UserContext();

        System.out.print("\n");
        MenuFactory.getFullLine();
        MenuFactory.getTitleLine(menuEntryName());
        MenuFactory.getPointLine("1.", "Logowania stałego użykownika.", null, null);
        MenuFactory.getPointLine("2.", "Logowanie nowego użytkownika.", null, null);
        MenuFactory.getPointLine("3.", "Wyjście.", null, null);
        MenuFactory.getFullLine();
        MenuFactory.getTitleLine("Wybierz numer opcji:");
        MenuFactory.getFullLine();
        userContext.setChoice(scanner.nextLine());
        new LoginMenuLogic().options(userContext);

    }

    @Override
    public String menuEntryName() {
        return "Logowanie";
    }
}
