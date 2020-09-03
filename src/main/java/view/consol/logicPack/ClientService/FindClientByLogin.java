package view.consol.logicPack.ClientService;

import domain.client.Client;
import logic.client.ClientServiceImpl;
import view.consol.logicPack.MenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.Scanner;

public class FindClientByLogin implements MenuEntry {
    @Override
    public String menuEntryName() {
        return "Znajdź użytkownika.";
    }

    @Override
    public void options() {
        Scanner scanner = new Scanner(System.in);

        boolean check;

        do {
            MenuFactory.getFullLine();
            MenuFactory.getTitleLine("Podaj login użytkownika, którego chcesz znaleźć.");
            MenuFactory.getTitleLine("(Jeżeli chcesz zrezygnować, wpisz Q.)");
            MenuFactory.getFullLine();
            System.out.println();

            String element = scanner.nextLine();

            String[] split = element.split(" ");
            if (split.length == 1) {

                ClientServiceImpl clientService = new ClientServiceImpl();
                Client client = clientService.findByLogin(element.trim());
                new UserContext().setClient(client);

                MenuFactory.getEmptyLine();
                MenuFactory.getTitleLine("Odnalazłeś użytkownika:");
                MenuFactory.getInfoLine(client.getName(), client.getSurname(), null, null);
                MenuFactory.getEmptyLine();

                check = true;
            } else {
                if (element.toUpperCase().trim().equals("Q")) {
                    MenuFactory.getEmptyLine();
                    MenuFactory.getTitleLine("Zrezygnowałeś z poszukiwania użytkownika.");
                    MenuFactory.getEmptyLine();
                    System.out.println();

                    //todo - przekierowanie do menu obsługującego dodawanie uzytkowników.

                }
                check = false;
                MenuFactory.getEmptyLine();
                MenuFactory.getTitleLine("Zostały podane błędne dane.");
                MenuFactory.getEmptyLine();
                System.out.println();
            }
        } while (!check);
    }
}
