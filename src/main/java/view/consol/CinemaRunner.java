package view.consol;

import view.consol.graphicsPack.StartMenu;

public class CinemaRunner {
    public static void main(String[] args) {

        StartMenu startMenu = new StartMenu();
        startMenu.printCinemaName();
        startMenu.printMenu();
    }
}
