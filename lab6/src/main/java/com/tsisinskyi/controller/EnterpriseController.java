package com.tsisinskyi.controller;


import com.tsisinskyi.DTO.EnterpriseDTO;
import com.tsisinskyi.mapper.EnterpriseMapper;
import com.tsisinskyi.model.Enterprise;
import com.tsisinskyi.service.EnterpriseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/enterprise")
public class EnterpriseController {
    private final EnterpriseService enterpriseService;

    @GetMapping
    public List<EnterpriseDTO> getAllEnterprise() {
        return enterpriseService.getAllEnterprise().stream().map(EnterpriseMapper::mapEnterpriseToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnterpriseDTO> getEnterpriseById(@PathVariable("id") Integer id) {
        Enterprise enterprise = enterpriseService.getEnterpriseById(id);
        if (enterprise == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                EnterpriseMapper.mapEnterpriseToDTO(enterprise), HttpStatus.OK);
    }

    @PostMapping
    public EnterpriseDTO createEnterprise(@RequestBody EnterpriseDTO enterpriseDTO) {
        return EnterpriseMapper.mapEnterpriseToDTO(enterpriseService.createEnterprise(enterpriseDTO));
    }

    @PutMapping
    public ResponseEntity<EnterpriseDTO> updateEnterprise(@RequestBody EnterpriseDTO enterpriseDTO) {
        Enterprise enterprise = enterpriseService.getEnterpriseById(enterpriseDTO.getId());
        if (enterprise == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                EnterpriseMapper.mapEnterpriseToDTO(enterpriseService.updateEnterprise(enterpriseDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<EnterpriseDTO> deleteEnterprise(@PathVariable("id") Integer id) {
        Enterprise enterprise = enterpriseService.getEnterpriseById(id);
        if (enterprise == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                EnterpriseMapper.mapEnterpriseToDTO(enterpriseService.deleteEnterpriseById(id)), HttpStatus.OK
        );
    }

}