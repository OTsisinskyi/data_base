package com.tsisinskyi.controller;

import com.tsisinskyi.DTO.CityDTO;
import com.tsisinskyi.mapper.CityMapper;
import com.tsisinskyi.model.City;
import com.tsisinskyi.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/city")
public class CityController {
    private final CityService cityService;

    @GetMapping
    public List<CityDTO> getAllCity() {
        return cityService.getAllCity().stream().map(CityMapper::mapCityToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{name}")
    public ResponseEntity<CityDTO> getCityByName(@PathVariable("name") String name) {
        City city = cityService.getCityByName(name);
        if (city == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CityMapper.mapCityToDTO(city), HttpStatus.OK);
    }

    @PostMapping
    public CityDTO createCity(@RequestBody CityDTO cityDTO) {
        return CityMapper.mapCityToDTO(cityService.createCity(cityDTO));
    }

    @PutMapping
    public ResponseEntity<CityDTO> updateCity(@RequestBody CityDTO cityDTO) {
        City city = cityService.getCityByName(cityDTO.getName());
        if (city == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CityMapper.mapCityToDTO(cityService.updateCity(cityDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<CityDTO> deleteCity(@PathVariable("name") String name) {
        City city = cityService.getCityByName(name);
        if (city == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CityMapper.mapCityToDTO(cityService.deleteCityById(name)), HttpStatus.OK
        );
    }

}