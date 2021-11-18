package com.tsisinskyi.controller;

import com.tsisinskyi.DTO.ChainDTO;
import com.tsisinskyi.mapper.ChainMapper;
import com.tsisinskyi.model.Chain;
import com.tsisinskyi.service.ChainService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/chain")
public class ChainController {
    private final ChainService chainService;

    @GetMapping
    public List<ChainDTO> getAllChain() {
        return chainService.getAllChain().stream().map(ChainMapper::mapChainToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChainDTO> getChainById(@PathVariable("id") Integer id) {
        Chain chain = chainService.getChainById(id);
        if (chain == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ChainMapper.mapChainToDTO(chain), HttpStatus.OK);
    }

    @PostMapping
    public ChainDTO createChain(@RequestBody ChainDTO chainDTO) {
        return ChainMapper.mapChainToDTO(chainService.createChain(chainDTO));
    }

    @PutMapping
    public ResponseEntity<ChainDTO> updateChain(@RequestBody ChainDTO chainDTO) {
        Chain chain = chainService.getChainById(chainDTO.getId());
        if (chain == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ChainMapper.mapChainToDTO(chainService.updateChain(chainDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ChainDTO> deleteChain(@PathVariable("id") Integer id) {
        Chain chain = chainService.getChainById(id);
        if (chain == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ChainMapper.mapChainToDTO(chainService.deleteChainById(id)), HttpStatus.OK
        );
    }

}
















