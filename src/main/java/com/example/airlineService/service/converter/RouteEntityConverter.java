package com.example.airlineService.service.converter;

import com.example.airlineService.model.dto.RouteDto;
import com.example.airlineService.model.entity.AirlineEntity;
import com.example.airlineService.model.entity.RouteEntity;
import org.springframework.stereotype.Component;

@Component
public class RouteEntityConverter {

    public RouteEntity convert(AirlineEntity airlineEntity, RouteDto routeDto) {
        RouteEntity routeEntity= new RouteEntity();
        routeEntity.setArrival(routeDto.getArrival());
        routeEntity.setDeparture(routeDto.getDeparture());
        routeEntity.setDepartureDate(routeDto.getDepartureDate());
        routeEntity.setArrivalDate(routeDto.getArrivalDate());
        routeEntity.setAirlineEntity(airlineEntity);
        return routeEntity;

    }
}
