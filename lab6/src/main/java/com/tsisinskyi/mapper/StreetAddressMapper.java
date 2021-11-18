package com.tsisinskyi.mapper;


import com.tsisinskyi.DTO.StreetAddressDTO;
import com.tsisinskyi.model.StreetAddress;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StreetAddressMapper {

    public static StreetAddressDTO mapStreetAddressToDTO(StreetAddress streetAddress) {
        return new StreetAddressDTO(streetAddress.getName());
    }

    public static StreetAddress mapDTOToStreetAddress(StreetAddressDTO streetAddressDTO) {
        return new StreetAddress(
                streetAddressDTO.getName()
        );
    }
}