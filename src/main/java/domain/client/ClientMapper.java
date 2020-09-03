package domain.client;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import persistence.client.ClientEntity;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientEntity clientToClientEntity(Client client);

    Client clientEntityToClient(ClientEntity clientEntity);
}
