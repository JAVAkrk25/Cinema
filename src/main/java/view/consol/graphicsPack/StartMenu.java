package view.consol.graphicsPack;

import lombok.RequiredArgsConstructor;
import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class StartMenu implements InterfaceMenuEntry {

    private final List<InterfaceMenuEntry> subMenu;

    Scanner scanner = new Scanner(System.in);

    @Override
    public void options(UserContext userContext) {
        printDescription();
//        do {
//
//        }
    }

    @Override
    public String menuEntryName() {
        return "Logowanie:";
    }


    private void printOptions() {
        System.out.print("\n\n");
        MenuFactory.getFullLine();
        MenuFactory.getTitleLine(menuEntryName());
//        MenuFactory.getPointLine();
    }

    private void printDescription() {
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
