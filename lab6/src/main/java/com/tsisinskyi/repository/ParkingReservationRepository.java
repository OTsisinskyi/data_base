package com.tsisinskyi.repository;

import com.tsisinskyi.model.ParkingReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingReservationRepository extends JpaRepository<ParkingReservation, Integer> {
}