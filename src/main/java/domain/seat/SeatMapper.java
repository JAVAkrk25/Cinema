package domain.seat;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import persistence.seat.SeatEntity;

import java.util.Set;

@Mapper
public interface SeatMapper {

    SeatMapper INSTANCES = Mappers.getMapper(SeatMapper.class);

    @Mapping(source = "filmShowRoom", target = "filmShowRoomEntity")
    @Mapping(source = "reservations", target = "reservationEntities")
    SeatEntity seatToSeatEntity(Seat seat);

    @InheritInverseConfiguration(name = "seatToSeatEntity")
    Seat seatEntityToSeat(SeatEntity seatEntity);

    Set<SeatEntity> seatToSeatEntity(Set<Seat> seats);

    Set<Seat> seatEntityToSeat(Set<SeatEntity> seatEntities);
}
