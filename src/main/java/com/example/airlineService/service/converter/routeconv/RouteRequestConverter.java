package com.example.airlineService.service.converter.routeconv;

import com.example.airlineService.controller.request.AddRouteReqeust;
import com.example.airlineService.model.dto.RouteDto;
import org.springframework.stereotype.Component;

@Component
public class RouteRequestConverter {
    public RouteDto convert(AddRouteReqeust request) {
        RouteDto routeDto = new RouteDto();
        routeDto.setArrival(request.getArrival());
        routeDto.setDeparture(request.getDeparture());
        routeDto.setArrivalDate(request.getArrivalDate());
        routeDto.setDepartureDate(request.getDepartureDate());
        routeDto.setAirlineId(request.getAirlineId());
        routeDto.setPrice(request.getPrice());
        return routeDto;
    }
}
