package persistence.client;


import persistence.EntityDAO;

public interface ClientDAO extends EntityDAO<ClientEntity> {

    ClientEntity findByLogin(String login);
}
