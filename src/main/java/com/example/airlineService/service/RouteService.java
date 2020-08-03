package com.example.airlineService.service;

import com.example.airlineService.controller.request.AddRouteReqeust;
import com.example.airlineService.controller.request.BookFlightRequest;
import com.example.airlineService.controller.request.SearchFlightRequest;
import com.example.airlineService.controller.response.BookFlightResponse;
import com.example.airlineService.model.dto.RouteDto;

import java.util.List;

public interface RouteService {

    RouteDto addRoute(AddRouteReqeust reqeust) throws Exception;

    RouteDto findRoutebyId(Long id) throws Exception;

    List<RouteDto> findByAirlineId(Long id) throws Exception;

    List<RouteDto> searchFlights(SearchFlightRequest request);



}

