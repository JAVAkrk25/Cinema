package destop;

import domain.Client;
import persistence.client.ClientDAO;
import persistence.client.ClientDAOImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema");
        ClientDAO clientDAO = new ClientDAOImpl(emf);

//        Client client1 = new Client( 1,"Jan", "Kowlaski", "j.k@em.pl", "6666666");
//        clientDAO.save(client1);

    }
}
