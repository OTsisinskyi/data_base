package com.tsisinskyi.mapper;

import com.tsisinskyi.DTO.ChainDTO;
import com.tsisinskyi.model.Chain;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ChainMapper {

    public static ChainDTO mapChainToDTO(Chain chain) {
        return new ChainDTO(
                chain.getId(),
                chain.getName()
        );
    }

    public static Chain mapDTOToChain(ChainDTO chainDTO) {
        return new Chain(
                chainDTO.getId(),
                chainDTO.getName()
        );
    }
}