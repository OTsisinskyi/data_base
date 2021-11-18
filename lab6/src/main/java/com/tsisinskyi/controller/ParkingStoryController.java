package com.tsisinskyi.controller;

import com.tsisinskyi.DTO.ParkingStoryDTO;
import com.tsisinskyi.mapper.ParkingStoryMapper;
import com.tsisinskyi.model.ParkingStory;
import com.tsisinskyi.service.ParkingStoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/parking_story")
public class ParkingStoryController {
    private final ParkingStoryService parkingStoryService;

    @GetMapping
    public List<ParkingStoryDTO> getAllParkingStory() {
        return parkingStoryService.getAllParkingStory().stream()
                .map(ParkingStoryMapper::mapParkingStoryToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingStoryDTO> getParkingById(@PathVariable("id") Integer id) {
        ParkingStory parkingStory = parkingStoryService.getParkingStoryById(id);
        if (parkingStory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ParkingStoryMapper.mapParkingStoryToDTO(parkingStory), HttpStatus.OK);
    }

    @PostMapping
    public ParkingStoryDTO createParkingStory(@RequestBody ParkingStoryDTO parkingStoryDTO) {
        return ParkingStoryMapper.mapParkingStoryToDTO(parkingStoryService.createParkingStory(parkingStoryDTO));
    }

    @PutMapping
    public ResponseEntity<ParkingStoryDTO> updateParkingStory(@RequestBody ParkingStoryDTO parkingStoryDTO) {
        ParkingStory parkingStory = parkingStoryService.getParkingStoryById(parkingStoryDTO.getId());
        if (parkingStory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ParkingStoryMapper.
                        mapParkingStoryToDTO(parkingStoryService.updateParkingStory(parkingStoryDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ParkingStoryDTO> deleteParkingStory(@PathVariable("id") Integer id) {
        ParkingStory parkingStory = parkingStoryService.getParkingStoryById(id);
        if (parkingStory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ParkingStoryMapper.mapParkingStoryToDTO(parkingStoryService.deleteParkingStoryById(id)), HttpStatus.OK
        );
    }

}