package com.tsisinskyi.service;

import com.tsisinskyi.DTO.EnterpriseDTO;
import com.tsisinskyi.mapper.EnterpriseMapper;
import com.tsisinskyi.model.Enterprise;
import com.tsisinskyi.repository.EnterpriseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    public List<Enterprise> getAllEnterprise() {
        return enterpriseRepository.findAll();
    }

    public Enterprise getEnterpriseById(Integer id) {
        return enterpriseRepository.findById(id).orElse(null);
    }

    public Enterprise createEnterprise(EnterpriseDTO enterpriseDTO) {
        return enterpriseRepository.save(EnterpriseMapper.mapDTOToEnterprise(enterpriseDTO));
    }

    public Enterprise updateEnterprise(EnterpriseDTO enterpriseDTO) {
        if (getEnterpriseById(enterpriseDTO.getId()) != null) {
            return enterpriseRepository.save(EnterpriseMapper.mapDTOToEnterprise(enterpriseDTO));
        }
        return null;
    }

    public Enterprise deleteEnterpriseById(Integer id) {
        Enterprise enterprise = getEnterpriseById(id);
        if (enterprise != null) {
            enterpriseRepository.deleteById(id);
            return enterprise;
        }
        return null;
    }
}