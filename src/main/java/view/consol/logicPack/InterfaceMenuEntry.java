package view.consol.logicPack;

public interface InterfaceMenuEntry {

    int LINE_LENGTH = 85;
    String SYMBOL = "*";

    void options(UserContext userContext);

    void printMenu();

    String menuEntryName();
}
