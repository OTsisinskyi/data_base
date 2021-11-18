package com.tsisinskyi.service;


import com.tsisinskyi.DTO.DistrictDTO;
import com.tsisinskyi.mapper.DistrictMapper;
import com.tsisinskyi.model.District;
import com.tsisinskyi.repository.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DistrictService {

    private final DistrictRepository districtRepository;

    public List<District> getAllDistrict() {
        return districtRepository.findAll();
    }

    public District getDistrictByName(String name) {
        return districtRepository.findById(name).orElse(null);
    }

    public District createDistrict(DistrictDTO districtDTO) {
        return districtRepository.save(DistrictMapper.mapDTOToDistrict(districtDTO));
    }

    public District updateDistrict(DistrictDTO districtDTO) {
        if (getDistrictByName(districtDTO.getName()) != null) {
            return districtRepository.save(DistrictMapper.mapDTOToDistrict(districtDTO));
        }
        return null;
    }

    public District deleteDistrictByName(String name) {
        District district = getDistrictByName(name);
        if (district != null) {
            districtRepository.deleteById(name);
            return district;
        }
        return null;
    }
}