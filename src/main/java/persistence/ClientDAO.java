package persistence;


public interface ClientDAO extends EntityDAO<ClientEntity> {

    ClientEntity findByLogin(String login);
}
