package domain;

import org.mapstruct.Mapper;
import persistence.ClientEntity;

@Mapper
public interface ClientMapper {

    ClientEntity clientToClientEntity(Client client);

    Client clientEntityToClient(ClientEntity clientEntity);
}
