package com.tsisinskyi.controller;

import com.tsisinskyi.DTO.ParkingDTO;
import com.tsisinskyi.mapper.ParkingMapper;
import com.tsisinskyi.model.Parking;
import com.tsisinskyi.service.ParkingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/parking")
public class ParkingController {
    private final ParkingService parkingService;

    @GetMapping
    public List<ParkingDTO> getAllParking() {
        return parkingService.getAllParking().stream().map(ParkingMapper::mapParkingToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> getParkingById(@PathVariable("id") Integer id) {
        Parking parking = parkingService.getParkingById(id);
        if (parking == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ParkingMapper.mapParkingToDTO(parking), HttpStatus.OK);
    }

    @PostMapping
    public ParkingDTO createParking(@RequestBody ParkingDTO parkingDTO) {
        return ParkingMapper.mapParkingToDTO(parkingService.createParking(parkingDTO));
    }

    @PutMapping
    public ResponseEntity<ParkingDTO> updateParking(@RequestBody ParkingDTO parkingDTO) {
        Parking parking = parkingService.getParkingById(parkingDTO.getId());
        if (parking == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ParkingMapper.mapParkingToDTO(parkingService.updateParking(parkingDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ParkingDTO> deleteParking(@PathVariable("id") Integer id) {
        Parking parking = parkingService.getParkingById(id);
        if (parking == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ParkingMapper.mapParkingToDTO(parkingService.deleteParkingById(id)), HttpStatus.OK
        );
    }

}
