package view.consol.logicPack.ClientService;

import logic.ClientService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.Scanner;

@RequiredArgsConstructor
public class AddClientMenuEntry implements InterfaceMenuEntry {

    private final ClientService clientService;

    @Override
    public void options(UserContext userContext) {
        Scanner scanner = new Scanner(System.in);
        MenuFactory.getTitleLine("Dodaj użytkownika");
        MenuFactory.getTitleLine("Podaj imię, nazwisko, email, numer telefonu");
        MenuFactory.getTitleLine("Podawane dane rozdziel przecinkami");
        MenuFactory.getEmptyLine();
        String element = scanner.nextLine();
        String[] split = element.split(",");
        if (split.length == 4){
            clientService.addClient(split[0].trim(), split[1].trim(), split[2].trim(), split[3].trim());
        }else {
            MenuFactory.getEmptyLine();
            MenuFactory.getTitleLine("Błędne dane.");
        }

    }

    @Override
    public String menuEntryName() {
        return "Dodaj użytkownika";
    }
}
