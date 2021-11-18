package com.tsisinskyi.mapper;

import com.tsisinskyi.DTO.ParkingDTO;
import com.tsisinskyi.model.Parking;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ParkingMapper {

    public static ParkingDTO mapParkingToDTO(Parking parking) {
        return new ParkingDTO(
                parking.getId(),
                parking.getTotalNumber(),
                parking.getPricePerHour(),
                parking.getStreetAddress(),
                parking.getDistrict(),
                parking.getCity(),
                parking.getChain()
        );
    }

    public static Parking mapDTOToParking(ParkingDTO parkingDTO) {
        return new Parking(
                parkingDTO.getId(),
                parkingDTO.getTotalNumber(),
                parkingDTO.getPricePerHour(),
                parkingDTO.getStreetAddress(),
                parkingDTO.getDistrict(),
                parkingDTO.getCity(),
                parkingDTO.getChain()
        );
    }
}