package com.tsisinskyi.service;

import com.tsisinskyi.DTO.ParkingStoryDTO;
import com.tsisinskyi.mapper.ParkingStoryMapper;
import com.tsisinskyi.model.ParkingStory;
import com.tsisinskyi.repository.ParkingStoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ParkingStoryService {

    private final ParkingStoryRepository parkingStoryRepository;

    public List<ParkingStory> getAllParkingStory() {
        return parkingStoryRepository.findAll();
    }

    public ParkingStory getParkingStoryById(Integer id) {
        return parkingStoryRepository.findById(id).orElse(null);
    }

    public ParkingStory createParkingStory(ParkingStoryDTO parkingStoryDTO) {
        return parkingStoryRepository.save(ParkingStoryMapper.mapDTOToParkingStory(parkingStoryDTO));
    }

    public ParkingStory updateParkingStory(ParkingStoryDTO parkingStoryDTO) {
        if (getParkingStoryById(parkingStoryDTO.getId()) != null) {
            return parkingStoryRepository.save(ParkingStoryMapper.mapDTOToParkingStory(parkingStoryDTO));
        }
        return null;
    }

    public ParkingStory deleteParkingStoryById(Integer id) {
        ParkingStory parkingParkingStory = getParkingStoryById(id);
        if (parkingParkingStory != null) {
            parkingStoryRepository.deleteById(id);
            return parkingParkingStory;
        }
        return null;
    }
}