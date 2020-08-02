package com.example.airlineService.service;


import com.example.airlineService.controller.request.AddAirportRequest;
import com.example.airlineService.controller.response.AddAirportResponse;
import com.example.airlineService.model.dto.AirportDto;

public interface AirportService {
    AddAirportResponse addAirport(AddAirportRequest request) throws Exception;
    AirportDto findAirportbyId(Long id) throws Exception;


}
