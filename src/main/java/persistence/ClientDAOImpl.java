package persistence;

import javax.persistence.EntityManagerFactory;

public class ClientDAOImpl extends AbstractEntityDao<ClientEntity> implements ClientDAO {

    public ClientDAOImpl(EntityManagerFactory emf) {
        super(emf, ClientEntity.class);
    }

}
