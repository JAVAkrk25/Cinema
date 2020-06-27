package persistence;


public interface ClientDAO extends EntityDAO<ClientEntity> {

    ClientEntity findByEmail(String email);
}
