package com.tsisinskyi.controller;


import com.tsisinskyi.DTO.DistrictDTO;
import com.tsisinskyi.mapper.DistrictMapper;
import com.tsisinskyi.model.District;
import com.tsisinskyi.service.DistrictService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/district")
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping
    public List<DistrictDTO> getAllDistrict() {
        return districtService.getAllDistrict().stream().map(DistrictMapper::mapDistrictToDTO).
                collect(Collectors.toList());
    }

    @GetMapping("/{name}")
    public ResponseEntity<DistrictDTO> getDistrictByName(@PathVariable("name") String name) {
        District district = districtService.getDistrictByName(name);
        if (district == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                DistrictMapper.mapDistrictToDTO(district), HttpStatus.OK);
    }

    @PostMapping
    public DistrictDTO createDistrict(@RequestBody DistrictDTO districtDTO) {
        return DistrictMapper.mapDistrictToDTO(districtService.createDistrict(districtDTO));
    }

    @PutMapping
    public ResponseEntity<DistrictDTO> updateDistrict(@RequestBody DistrictDTO districtDTO) {
        District district = districtService.getDistrictByName(districtDTO.getName());
        if (district == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                DistrictMapper.mapDistrictToDTO(districtService.updateDistrict(districtDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<DistrictDTO> deleteCity(@PathVariable("name") String name) {
        District district = districtService.getDistrictByName(name);
        if (district == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                DistrictMapper.mapDistrictToDTO(districtService.deleteDistrictByName(name)), HttpStatus.OK
        );
    }

}