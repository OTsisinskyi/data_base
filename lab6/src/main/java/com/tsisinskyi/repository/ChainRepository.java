package com.tsisinskyi.repository;

import com.tsisinskyi.model.Chain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainRepository extends JpaRepository<Chain, Integer> {
}