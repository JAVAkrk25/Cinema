package domain.reservation;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import persistence.reservation.ReservationEntity;

@Mapper
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(source = "seans", target = "seansEntity")
    @Mapping(source = "client", target = "clientEntity")
    @Mapping(source = "seat", target = "seatEntity")
    ReservationEntity reservationToReservationEntity(Reservation reservation);

    @InheritInverseConfiguration(name = "reservationToReservationEntity")
    Reservation reservationEntityToReservation(ReservationEntity reservationEntity);
}
