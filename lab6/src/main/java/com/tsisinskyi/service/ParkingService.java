package com.tsisinskyi.service;

import com.tsisinskyi.DTO.ParkingDTO;
import com.tsisinskyi.mapper.ParkingMapper;
import com.tsisinskyi.model.Parking;
import com.tsisinskyi.repository.ParkingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    public List<Parking> getAllParking() {
        return parkingRepository.findAll();
    }

    public Parking getParkingById(Integer id) {
        return parkingRepository.findById(id).orElse(null);
    }

    public Parking createParking(ParkingDTO parkingDTO) {
        return parkingRepository.save(ParkingMapper.mapDTOToParking(parkingDTO));
    }

    public Parking updateParking(ParkingDTO parkingDTO) {
        if (getParkingById(parkingDTO.getId()) != null) {
            return parkingRepository.save(ParkingMapper.mapDTOToParking(parkingDTO));
        }
        return null;
    }

    public Parking deleteParkingById(Integer id) {
        Parking parking = getParkingById(id);
        if (parking != null) {
            parkingRepository.deleteById(id);
            return parking;
        }
        return null;
    }
}