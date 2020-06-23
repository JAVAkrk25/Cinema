package persistence.client;

import domain.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ClientDAOImpl implements ClientDAO {
    private final EntityManagerFactory emf;

    public ClientDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(Client client) {
        EntityManager cl = null;
        try {
            cl = emf.createEntityManager();
            cl.getTransaction().begin();
            cl.persist(from(client));
            cl.getTransaction().commit();
        } finally {
            if (cl != null) {
                cl.close();
            }
        }
    }

    @Override
    public void update(Client client) {
        EntityManager cl = null;
        try {
            cl = emf.createEntityManager();
            cl.getTransaction().begin();
            cl.merge(from(client));
            cl.getTransaction().commit();
        } finally {
            if (cl != null) {
                cl.close();
            }
        }
    }

    @Override
    public void delete(String clientId) {
        EntityManager cl = null;
        try {
            cl = emf.createEntityManager();
            cl.getTransaction().begin();
            ClientEntity employeeEntity = cl.find(ClientEntity.class, clientId);
            if (employeeEntity != null) {
                cl.remove(employeeEntity);
            }
            cl.getTransaction().commit();
        } finally {
            if (cl != null) {
                cl.close();
            }
        }
    }

    private Client from(ClientEntity clientEntity) {
        return clientEntity == null ? null :
                new Client(clientEntity.getClientId(), clientEntity.getName(), clientEntity.getSurname(), clientEntity.getEmail(), clientEntity.getPhone());
    }

    private ClientEntity from(Client client) {
        return client == null ? null :
                new ClientEntity(client.getClientId(), client.getName(), client.getSurname(), client.getEmail(), client.getPhone());
    }


}
