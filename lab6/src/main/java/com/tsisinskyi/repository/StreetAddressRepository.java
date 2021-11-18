package com.tsisinskyi.repository;

import com.tsisinskyi.model.StreetAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetAddressRepository extends JpaRepository<StreetAddress, String> {
}