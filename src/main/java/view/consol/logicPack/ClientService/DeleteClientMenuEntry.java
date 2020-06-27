package view.consol.logicPack.ClientService;

import logic.ClientService;
import lombok.RequiredArgsConstructor;
import view.consol.logicPack.InterfaceMenuEntry;
import view.consol.logicPack.MenuFactory;
import view.consol.logicPack.UserContext;

import java.util.Scanner;

@RequiredArgsConstructor
public class DeleteClientMenuEntry implements InterfaceMenuEntry {

    private final ClientService clientService;

    @Override
    public void options(UserContext userContext) {
        Scanner scanner = new Scanner(System.in);
        MenuFactory.getTitleLine("Podaj identyfikator użytkownika do usuniecia:");
        MenuFactory.getEmptyLine();
        String element = scanner.nextLine();
        String[] split = element.split(" ");
        if (split.length == 1) {
            clientService.delete(Integer.parseInt(split[0]));
        } else {
            MenuFactory.getEmptyLine();
            MenuFactory.getTitleLine("Błędne dane.");
        }
    }

    @Override
    public void printMenu() {

    }

    @Override
    public String menuEntryName() {
        return "Usuń użytkownika";
    }
}
