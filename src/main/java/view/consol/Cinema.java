package view.consol;

import view.consol.graphicsPack.StartMenu;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Cinema {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SqtyJ7nmGK");

        new StartMenu().printMenu();
    }
}
