package persistence;

import utils.Mapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class ClientDAOImpl extends AbstractEntityDao<ClientEntity> implements ClientDAO {

    public ClientDAOImpl(EntityManagerFactory emf) {
        super(emf, ClientEntity.class);
    }

    @Override
    public ClientEntity findByEmail(String email) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            TypedQuery<ClientEntity> query = entityManager.createQuery("FROM ClientEntity c WHERE c.email=:email", ClientEntity.class);
            query.setParameter("email", email);
            ClientEntity foundEntity = query.getSingleResult();
            transaction.commit();
            return foundEntity;
        } finally {
            if (entityManager != null){
                entityManager.close();
            }
        }
    }
}
