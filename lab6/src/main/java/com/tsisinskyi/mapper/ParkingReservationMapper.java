package com.tsisinskyi.mapper;

import com.tsisinskyi.DTO.ParkingReservationDTO;
import com.tsisinskyi.model.ParkingReservation;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ParkingReservationMapper {
    public static ParkingReservationDTO mapParkingReservationToDTO(ParkingReservation parkingReservation) {
        return new ParkingReservationDTO(
                parkingReservation.getId(),
                parkingReservation.getCarNumber(),
                parkingReservation.getTime(),
                parkingReservation.getParking_id()
        );
    }

    public static ParkingReservation mapDTOToParkingReservation(ParkingReservationDTO parkingReservationDTO) {
        return new ParkingReservation(
                parkingReservationDTO.getId(),
                parkingReservationDTO.getCarNumber(),
                parkingReservationDTO.getTime(),
                parkingReservationDTO.getParking_id()
        );
    }
}