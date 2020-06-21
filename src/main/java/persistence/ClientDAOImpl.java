package persistence;

import domain.Client;
import domain.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Set;

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

    @Override
    public Set<Movie> findMovie(String movieId) {
//        EntityManager cl = null;
//        try {
//            cl = emf.createEntityManager();
//            cl.getTransaction().begin();
//            TypedQuery<MovieEntity> query = cl.createQuery("FROM Movie m WHERE m.movieId = :movieId", Movie.class);
//            query.setParameter("movieId", movieId);
//            Set<Movie> result = query.getResultStream().map(this::from).collect(Collectors.toSet());
//            cl.getTransaction().commit();
//            return result;
//        } finally {
//            if (cl != null) {
//                cl.close();
//            }
//        }
        return null;
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
