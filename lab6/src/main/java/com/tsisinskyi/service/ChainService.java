package com.tsisinskyi.service;

import com.tsisinskyi.DTO.ChainDTO;
import com.tsisinskyi.mapper.ChainMapper;
import com.tsisinskyi.model.Chain;
import com.tsisinskyi.repository.ChainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ChainService {

    private final ChainRepository chainRepository;

    public List<Chain> getAllChain() {
        return chainRepository.findAll();
    }

    public Chain getChainById(Integer id) {
        return chainRepository.findById(id).orElse(null);
    }

    public Chain createChain(ChainDTO chainDTO) {
        return chainRepository.save(ChainMapper.mapDTOToChain(chainDTO));
    }

    public Chain updateChain(ChainDTO chainDTO) {
        if (getChainById(chainDTO.getId()) != null) {
            return chainRepository.save(ChainMapper.mapDTOToChain(chainDTO));
        }
        return null;
    }

    public Chain deleteChainById(Integer id) {
        Chain chain = getChainById(id);
        if (chain != null) {
            chainRepository.deleteById(id);
            return chain;
        }
        return null;
    }
}