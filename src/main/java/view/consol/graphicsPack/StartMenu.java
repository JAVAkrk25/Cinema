package view.consol.graphicsPack;

import view.consol.logicPack.Logic.StartMenuLogic;
import view.consol.logicPack.MenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.Scanner;


public class StartMenu implements MenuEntry {

    @Override
    public String menuEntryName() {
        return "Logowanie:";
    }

    @Override
    public void options() {

        Scanner scanner = new Scanner(System.in);
        UserContext userContext = new UserContext();

        MenuFactory.getFullLine();
        MenuFactory.getPointLine("1.", "Logowania stałego użykownika.", null, null);
        MenuFactory.getPointLine("2.", "Logowanie nowego użytkownika.", null, null);
        MenuFactory.getPointLine("3.", "Wyjście.", null, null);
        MenuFactory.getFullLine();
        MenuFactory.getTitleLine("Wybierz numer opcji:");
        MenuFactory.getFullLine();
        System.out.println();
        userContext.setChoice(scanner.nextLine());
        new StartMenuLogic().options();
    }

    public void printCinemaName() {
        System.out.print("\n\n\n");
        MenuFactory.getFullLine();
        MenuFactory.getEmptyLine();
        MenuFactory.getCentreLine("KINO");
        MenuFactory.getCentreLine("RUCHOME  OBRAZY");
        MenuFactory.getEmptyLine();
        MenuFactory.getFullLine();
        MenuFactory.getEmptyLine();
        MenuFactory.getCentreLine("Witamy w naszym kinie, cieszymy się, że zechciałeś z niego skorzystać.");
        MenuFactory.getEmptyLine();
        MenuFactory.getFullLine();
        System.out.println();
    }
}
