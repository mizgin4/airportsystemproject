package com.example.airlineService.repositroy;

import com.example.airlineService.model.entity.AirlineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<AirlineEntity, Long> {
    AirlineEntity findByAirlineName(String airlineName);

}
