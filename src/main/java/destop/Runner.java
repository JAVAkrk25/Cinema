package destop;

import domain.Client;
import logic.ClientService;
import logic.ClientServiceImpl;
import persistence.ClientDAO;
import persistence.ClientDAOImpl;
import persistence.ClientEntity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema");
        ClientDAO clientDAO = new ClientDAOImpl(emf);

        ClientService clientService = new ClientServiceImpl(clientDAO);
        clientService.addClient("Janina", "Nowak", "janina.nowak@jmail.pl", "999666666");
        
    }
}
