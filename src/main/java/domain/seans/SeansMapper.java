package domain.seans;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import persistence.seans.SeansEntity;

import java.util.Set;

@Mapper
public interface SeansMapper {

    SeansMapper INSTANCE = Mappers.getMapper(SeansMapper.class);

    @Mapping(source = "filmShowRoom", target = "filmShowRoomEntity")
    @Mapping(source = "reservations", target = "reservationEntity")
    SeansEntity seansToSeansEntity(Seans seans);

    @InheritInverseConfiguration(name = "seansToSeansEntity")
    Seans seansEntityToSeans(SeansEntity seansEntity);

    Set<SeansEntity> seansToSeansEntity(Set<Seans> seans);

    Set<Seans> seansEntityToSeans(Set<SeansEntity> seansEntities);
}
