package com.tsisinskyi.mapper;

import com.tsisinskyi.DTO.DistrictDTO;
import com.tsisinskyi.model.District;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DistrictMapper {

    public static DistrictDTO mapDistrictToDTO(District district) {
        return new DistrictDTO(
                district.getName()
        );
    }

    public static District mapDTOToDistrict(DistrictDTO districtDTO) {
        return new District(
                districtDTO.getName()
        );
    }
}