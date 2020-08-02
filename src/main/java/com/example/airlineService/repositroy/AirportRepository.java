package com.example.airlineService.repositroy;

import com.example.airlineService.model.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<AirportEntity,Long> {
    AirportEntity findByAirportName(String name);
}
