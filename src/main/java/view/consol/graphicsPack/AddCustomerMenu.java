package view.consol.graphicsPack;

import view.consol.logicPack.MenuEntry;
import view.consol.logicPack.Logic.AddCustomerMenuLogic;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.Scanner;

public class AddCustomerMenu implements MenuEntry {


    @Override
    public String menuEntryName() {
        return "Nowy Użytkownik.";
    }

    @Override
    public void options() {

        Scanner scanner = new Scanner(System.in);
        UserContext userContext = new UserContext();

        MenuFactory.getFullLine();
        MenuFactory.getPointLine("1.", "Utwórz nowego użytkownika.", null, null);
        MenuFactory.getPointLine("2.", "Powrót do poprzedniego menu.", null, null);
        MenuFactory.getPointLine("3.", "Wyjście.", null, null);
        MenuFactory.getFullLine();
        MenuFactory.getTitleLine("Wybierz numer opcji:");
        MenuFactory.getFullLine();
        userContext.setChoice(scanner.nextLine());
        new AddCustomerMenuLogic().options();

    }
}
