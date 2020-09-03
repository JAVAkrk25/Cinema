package persistence.client;

import persistence.EntityDAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class ClientDAOImpl extends EntityDAOImpl<ClientEntity> implements ClientDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public ClientDAOImpl() {
        super(ClientEntity.class);
    }

    @Override
    public ClientEntity findByLogin(String login) {
        TypedQuery<ClientEntity> query = entityManager.createQuery("FROM ClientEntity WHERE ClientEntity.login=:login", ClientEntity.class);
        query.setParameter("login", login);
        return query.getSingleResult();
    }
}
