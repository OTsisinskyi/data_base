package com.tsisinskyi.repository;


import com.tsisinskyi.model.ParkingStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingStoryRepository extends JpaRepository<ParkingStory, Integer> {
}