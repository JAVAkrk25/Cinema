package view.consol.logicPack.Logic;

import view.consol.graphicsPack.CustomerLoginMenu;
import view.consol.graphicsPack.StartMenu;
import view.consol.logicPack.ClientService.AddClient;
import view.consol.logicPack.MenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

public class AddCustomerMenuLogic implements MenuEntry {

    UserContext userContext;

    @Override
    public String menuEntryName() {
        return null;
    }

    @Override
    public void options() {

        switch (userContext.getChoice()) {
            case "1" -> {
                new AddClient().printMenu();
                new StartMenu().printMenu();
            }
            case "2" -> new StartMenu().printMenu();
            case "3" -> System.exit(0);
            default -> {
                MenuFactory.getFullLine();
                MenuFactory.getTitleLine("Została wybrana błędna opcja.");
                MenuFactory.getFullLine();
                System.out.println();
                new CustomerLoginMenu().printMenu();
            }
        }
    }
}
