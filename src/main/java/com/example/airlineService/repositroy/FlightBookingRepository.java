package com.example.airlineService.repositroy;

import com.example.airlineService.model.entity.FlightBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBookingEntity,Long> {

}
