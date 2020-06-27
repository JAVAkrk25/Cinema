package view.consol.graphicsPack;

import lombok.RequiredArgsConstructor;
import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.Logic.StartMenuLogic;
import view.consol.logicPack.UserContext;

import java.util.Scanner;

@RequiredArgsConstructor
public class StartMenu implements InterfaceMenuEntry {


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
        new StartMenuLogic().options(userContext);
    }

    @Override
    public String menuEntryName() {
        return "Logowanie:";
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
    }
}
