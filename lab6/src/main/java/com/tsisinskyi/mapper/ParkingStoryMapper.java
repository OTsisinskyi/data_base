package com.tsisinskyi.mapper;

import com.tsisinskyi.DTO.ParkingStoryDTO;
import com.tsisinskyi.model.ParkingStory;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ParkingStoryMapper {

    public static ParkingStoryDTO mapParkingStoryToDTO(ParkingStory parkingStory) {
        return new ParkingStoryDTO(
                parkingStory.getId(),
                parkingStory.getParking_id(),
                parkingStory.getUser_card_id(),
                parkingStory.getNumberCar(),
                parkingStory.getAction(),
                parkingStory.getTimestamp()
        );
    }

    public static ParkingStory mapDTOToParkingStory(ParkingStoryDTO parkingStoryDTO) {
        return new ParkingStory(
                parkingStoryDTO.getId(),
                parkingStoryDTO.getParking_id(),
                parkingStoryDTO.getUser_card_id(),
                parkingStoryDTO.getNumberCar(),
                parkingStoryDTO.getAction(),
                parkingStoryDTO.getTimestamp()
        );
    }
}