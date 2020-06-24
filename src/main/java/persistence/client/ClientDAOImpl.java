package persistence.client;

import domain.Client;
import utils.Mapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ClientDAOImpl implements ClientDAO {
    private final EntityManagerFactory emf;

    public ClientDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Client findById(int id) {
        return null;
    }

    @Override
    public void save(Client client) {
        EntityManager cl = null;
        try {
            cl = emf.createEntityManager();
            cl.getTransaction().begin();
            cl.persist(Mapper.from(client));
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
            cl.merge(Mapper.from(client));
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
}
