package view.consol;

import view.consol.graphicsPack.StartMenu;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CinemaRunner {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SqtyJ7nmGK");

        StartMenu startMenu = new StartMenu();
        startMenu.printCinemaName();
        startMenu.printMenu();
    }
}
