package view.consol.logicPack.ClientService;

import logic.ClientServiceImpl;
import view.consol.logicPack.MenuEntry;
import view.consol.logicPack.MenuFactory;

import java.util.Scanner;

public class AddClient implements MenuEntry {

    @Override
    public String menuEntryName() {
        return "Dodaj nowego użytkownika.";
    }

    @Override
    public void options() {
        Scanner scanner = new Scanner(System.in);

        boolean check;

        do {
            MenuFactory.getFullLine();
            MenuFactory.getTitleLine("Podaj swoje dane rzdzielone przecinkami:");
            MenuFactory.getTitleLine("imię, nazwisko, adres email, numer telefonu, login, hasło.");
            MenuFactory.getTitleLine("(Jeżeli chcesz zrezygnować, wpisz Q.)");
            MenuFactory.getFullLine();
            System.out.println();

            String element = scanner.nextLine();

            String[] split = element.split(",");
            if (split.length == 6) {
                new ClientServiceImpl().addClient(
                        split[0].trim(),
                        split[1].trim(),
                        split[2].trim(),
                        split[3].trim(),
                        split[4].trim(),
                        split[5].trim());
                check = true;
            } else {
                if (element.toUpperCase().trim().equals("Q")) {
                    MenuFactory.getEmptyLine();
                    MenuFactory.getTitleLine("Zrezygnowałeś z dodania nowego użytkownika.");
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

    @Override
    public void printMenu() {

        MenuFactory.getFullLine();
        MenuFactory.getTitleLine(menuEntryName());
        MenuFactory.getFullLine();
        System.out.println();

        options();
    }
}
