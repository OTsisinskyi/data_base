package com.tsisinskyi.controller;

import com.tsisinskyi.DTO.ParkingReservationDTO;
import com.tsisinskyi.mapper.ParkingReservationMapper;
import com.tsisinskyi.model.ParkingReservation;
import com.tsisinskyi.service.ParkingReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/parking_reservation")
public class ParkingReservationController {
    private final ParkingReservationService parkingReservationService;

    @GetMapping
    public List<ParkingReservationDTO> getAllParkingReservation() {
        return parkingReservationService.getAllParkingReservation().stream()
                .map(ParkingReservationMapper::mapParkingReservationToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingReservationDTO> getParkingById(@PathVariable("id") Integer id) {
        ParkingReservation parkingReservation = parkingReservationService.getParkingReservationById(id);
        if (parkingReservation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ParkingReservationMapper.mapParkingReservationToDTO(parkingReservation), HttpStatus.OK);
    }

    @PostMapping
    public ParkingReservationDTO createParkingReservation(@RequestBody ParkingReservationDTO parkingReservationDTO) {
        return ParkingReservationMapper.
                mapParkingReservationToDTO(parkingReservationService.createParkingReservation(parkingReservationDTO));
    }

    @PutMapping
    public ResponseEntity<ParkingReservationDTO> updateParkingReservation(@RequestBody ParkingReservationDTO parkingReservationDTO) {
        ParkingReservation parkingReservation = parkingReservationService.
                getParkingReservationById(parkingReservationDTO.getId());
        if (parkingReservation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ParkingReservationMapper.
                        mapParkingReservationToDTO(parkingReservationService.
                                updateParkingReservation(parkingReservationDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ParkingReservationDTO> deleteParkingReservation(@PathVariable("id") Integer id) {
        ParkingReservation parkingReservation = parkingReservationService.getParkingReservationById(id);
        if (parkingReservation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ParkingReservationMapper.mapParkingReservationToDTO(parkingReservationService.
                        deleteParkingReservationById(id)), HttpStatus.OK
        );
    }

}
