package com.tsisinskyi.service;

import com.tsisinskyi.DTO.ParkingReservationDTO;
import com.tsisinskyi.mapper.ParkingReservationMapper;
import com.tsisinskyi.model.ParkingReservation;
import com.tsisinskyi.repository.ParkingReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ParkingReservationService {

    private final ParkingReservationRepository parkingReservationRepository;

    public List<ParkingReservation> getAllParkingReservation() {
        return parkingReservationRepository.findAll();
    }

    public ParkingReservation getParkingReservationById(Integer id) {
        return parkingReservationRepository.findById(id).orElse(null);
    }

    public ParkingReservation createParkingReservation(ParkingReservationDTO parkingReservationDTO) {
        return parkingReservationRepository.save(ParkingReservationMapper.mapDTOToParkingReservation(parkingReservationDTO));
    }

    public ParkingReservation updateParkingReservation(ParkingReservationDTO parkingReservationDTO) {
        if (getParkingReservationById(parkingReservationDTO.getId()) != null) {
            return parkingReservationRepository.save(ParkingReservationMapper.mapDTOToParkingReservation(parkingReservationDTO));
        }
        return null;
    }

    public ParkingReservation deleteParkingReservationById(Integer id) {
        ParkingReservation parkingReservation = getParkingReservationById(id);
        if (parkingReservation != null) {
            parkingReservationRepository.deleteById(id);
            return parkingReservation;
        }
        return null;
    }
}