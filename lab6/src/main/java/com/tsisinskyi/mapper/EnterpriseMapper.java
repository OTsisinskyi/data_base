package com.tsisinskyi.mapper;

import com.tsisinskyi.DTO.EnterpriseDTO;
import com.tsisinskyi.model.Enterprise;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EnterpriseMapper {

    public static EnterpriseDTO mapEnterpriseToDTO(Enterprise enterprise) {
        return new EnterpriseDTO(
                enterprise.getId(),
                enterprise.getName()
        );
    }

    public static Enterprise mapDTOToEnterprise(EnterpriseDTO enterpriseDTO) {
        return new Enterprise(
                enterpriseDTO.getId(),
                enterpriseDTO.getName()
        );
    }
}