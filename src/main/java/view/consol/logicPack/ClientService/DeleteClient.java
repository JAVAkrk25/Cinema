package view.consol.logicPack.ClientService;

import domain.Client;
import logic.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.MenuEntry;
import view.consol.logicPack.MenuFactory;

import java.util.Scanner;

@RequiredArgsConstructor
public class DeleteClient implements MenuEntry {

    @Override
    public String menuEntryName() {
        return "Usuń użytkownika.";
    }

    @Override
    public void options() {
        Scanner scanner = new Scanner(System.in);

        boolean check;

        do {
            MenuFactory.getFullLine();
            MenuFactory.getTitleLine("Podaj login użytkownika, którego chcesz usumąć.");
            MenuFactory.getTitleLine("(Jeżeli chcesz zrezygnować, wpisz Q.)");
            MenuFactory.getFullLine();
            System.out.println();

            String element1 = scanner.nextLine();

            String[] split = element1.split(" ");
            if (split.length == 1) {

                ClientServiceImpl clientService = new ClientServiceImpl();
                Client client = clientService.findByLogin(element1.trim());

                MenuFactory.getEmptyLine();
                MenuFactory.getTitleLine("Czy ns pewno chcesz usunąć użytkownika:");
                MenuFactory.getInfoLine(client.getName(), client.getSurname(), null, null);
                MenuFactory.getTitleLine("(T)ak / (N)ie ?");
                MenuFactory.getEmptyLine();

                String element2 = scanner.nextLine();

                if (element2.toUpperCase().trim().equals("T")) {
                    clientService.delete(client.getClientId());
                } else {
                    MenuFactory.getEmptyLine();
                    MenuFactory.getTitleLine("Zrezygnowałeś z usunięcia użytkownika.");
                    MenuFactory.getEmptyLine();
                    System.out.println();

                    //todo - przekierowanie do menu obsługującego dodawanie uzytkowników.
                }

                check = true;
            } else {
                if (element1.toUpperCase().trim().equals("Q")) {
                    MenuFactory.getEmptyLine();
                    MenuFactory.getTitleLine("Zrezygnowałeś z usunięcia użytkownika.");
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
