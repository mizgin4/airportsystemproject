package com.example.airlineService.repositroy;

import com.example.airlineService.controller.request.AddRouteReqeust;
import com.example.airlineService.controller.request.SearchFlightRequest;
import com.example.airlineService.model.entity.AirlineEntity;
import com.example.airlineService.model.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RouteRepository extends JpaRepository<RouteEntity,Long> {

    List<RouteEntity> findByAirlineEntity(AirlineEntity airlineEntity);
    List<RouteEntity> findByDepartureAndArrivalAndArrivalDateAndDepartureDate(String departure, String arrival, LocalDate arrivalDate,LocalDate departureDate);


}
