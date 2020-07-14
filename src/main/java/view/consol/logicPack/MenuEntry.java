package view.consol.logicPack;

public interface MenuEntry {

    int LINE_LENGTH = 85;
    String SYMBOL = "*";

    String menuEntryName();

    void options();

    default void printMenu(){

        MenuFactory.getFullLine();
        MenuFactory.getTitleLine(menuEntryName());
        MenuFactory.getFullLine();
        System.out.println();

        options();
    };
}
