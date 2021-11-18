package com.tsisinskyi.service;


import com.tsisinskyi.DTO.StreetAddressDTO;
import com.tsisinskyi.mapper.StreetAddressMapper;
import com.tsisinskyi.model.StreetAddress;
import com.tsisinskyi.repository.StreetAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StreetAddressService {

    private final StreetAddressRepository streetAddressRepository;

    public List<StreetAddress> getAllStreetAddress() {
        return streetAddressRepository.findAll();
    }

    public StreetAddress getStreetAddressByName(String name) {
        return streetAddressRepository.findById(name).orElse(null);
    }

    public StreetAddress createStreetAddress(StreetAddressDTO streetAddressDTO) {
        return streetAddressRepository.save(StreetAddressMapper.mapDTOToStreetAddress(streetAddressDTO));
    }

    public StreetAddress updateStreetAddress(StreetAddressDTO streetAddressDTO) {
        if (getStreetAddressByName(streetAddressDTO.getName()) != null) {
            return streetAddressRepository.save(StreetAddressMapper.mapDTOToStreetAddress(streetAddressDTO));
        }
        return null;
    }

    public StreetAddress deleteStreetAddressById(String name) {
        StreetAddress streetAddress = getStreetAddressByName(name);
        if (streetAddress != null) {
            streetAddressRepository.deleteById(name);
            return streetAddress;
        }
        return null;
    }
}