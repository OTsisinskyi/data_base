package com.tsisinskyi.mapper;

import com.tsisinskyi.DTO.CityDTO;
import com.tsisinskyi.model.City;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CityMapper {

    public static CityDTO mapCityToDTO(City city) {
        return new CityDTO(
                city.getName()
        );
    }

    public static City  mapDTOToCity(CityDTO cityDTO) {
        return new City(
                cityDTO.getName()
        );
    }
}