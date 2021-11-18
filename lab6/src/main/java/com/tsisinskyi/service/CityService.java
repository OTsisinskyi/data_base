package com.tsisinskyi.service;

import com.tsisinskyi.DTO.CityDTO;
import com.tsisinskyi.mapper.CityMapper;
import com.tsisinskyi.model.City;
import com.tsisinskyi.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CityService {

    private final CityRepository cityRepository;

    public List<City> getAllCity() {
        return cityRepository.findAll();
    }

    public City getCityByName(String name) {
        return cityRepository.findById(name).orElse(null);
    }

    public City createCity(CityDTO cityDTO) {
        return cityRepository.save(CityMapper.mapDTOToCity(cityDTO));
    }

    public City updateCity(CityDTO cityDTO) {
        if (getCityByName(cityDTO.getName()) != null) {
            return cityRepository.save(CityMapper.mapDTOToCity(cityDTO));
        }
        return null;
    }

    public City deleteCityById(String name) {
        City city = getCityByName(name);
        if (city != null) {
            cityRepository.deleteById(name);
            return city;
        }
        return null;
    }
}