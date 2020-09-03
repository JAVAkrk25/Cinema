package domain.filmShowRoom;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import persistence.filmShowRoom.FilmShowRoomEntity;

@Mapper
public interface FilmShowRoomMapper {

    FilmShowRoomMapper INSTANCE = Mappers.getMapper(FilmShowRoomMapper.class);

    @Mapping(source = "seans", target = "seansEntities")
    @Mapping(source = "seats", target = "seatEntities")
    FilmShowRoomEntity filmShowRoomToFilmShowRoomEntity(FilmShowRoom filmShowRoom);

    @InheritInverseConfiguration(name = "filmShowRoomToFilmShowRoomEntity")
    FilmShowRoom filmShowRoomEntityToFilmShowRoom(FilmShowRoomEntity filmShowRoomEntity);
}
