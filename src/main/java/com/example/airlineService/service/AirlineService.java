package com.example.airlineService.service;

import com.example.airlineService.controller.request.AddAirlineRequest;
import com.example.airlineService.controller.response.AddAirlineResponse;
import com.example.airlineService.model.dto.AirlineDto;

public interface AirlineService {
    AddAirlineResponse addAirline(AddAirlineRequest request) throws Exception;
    AirlineDto findAirlineById(Long id) throws Exception;
}
