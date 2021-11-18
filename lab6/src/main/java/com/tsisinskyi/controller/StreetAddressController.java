package com.tsisinskyi.controller;

import com.tsisinskyi.DTO.StreetAddressDTO;
import com.tsisinskyi.mapper.StreetAddressMapper;
import com.tsisinskyi.model.StreetAddress;
import com.tsisinskyi.service.StreetAddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/street_address")
public class StreetAddressController {
    private final StreetAddressService streetAddressService;

    @GetMapping
    public List<StreetAddressDTO> getAllStreetAddress() {
        return streetAddressService.getAllStreetAddress().stream()
                .map(StreetAddressMapper::mapStreetAddressToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{name}")
    public ResponseEntity<StreetAddressDTO> getStreetAddressByName(@PathVariable("name") String name) {
        StreetAddress streetAddress = streetAddressService.getStreetAddressByName(name);
        if (streetAddress == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                StreetAddressMapper.mapStreetAddressToDTO(streetAddress), HttpStatus.OK);
    }

    @PostMapping
    public StreetAddressDTO createStreetAddress(@RequestBody StreetAddressDTO streetAddressDTO) {
        return StreetAddressMapper.mapStreetAddressToDTO(streetAddressService.createStreetAddress(streetAddressDTO));
    }

    @PutMapping
    public ResponseEntity<StreetAddressDTO> updateStreetAddress(@RequestBody StreetAddressDTO streetAddressDTO) {
        StreetAddress streetAddress = streetAddressService.getStreetAddressByName(streetAddressDTO.getName());
        if (streetAddress == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                StreetAddressMapper.mapStreetAddressToDTO(streetAddressService.
                        updateStreetAddress(streetAddressDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<StreetAddressDTO> deleteStreetAddress(@PathVariable("name") String name) {
        StreetAddress streetAddress = streetAddressService.getStreetAddressByName(name);
        if (streetAddress == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                StreetAddressMapper.mapStreetAddressToDTO(streetAddressService.
                        deleteStreetAddressById(name)), HttpStatus.OK
        );
    }

}