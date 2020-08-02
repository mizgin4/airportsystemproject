package com.example.airlineService.controller;

import com.example.airlineService.controller.request.AddAirportRequest;
import com.example.airlineService.controller.response.AddAirportResponse;
import com.example.airlineService.model.dto.AirportDto;
import com.example.airlineService.service.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/airport")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddAirportResponse> addAirport(@RequestBody AddAirportRequest request) throws Exception {
        return ResponseEntity.ok(airportService.addAirport(request));
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<AirportDto> findAirportbyId(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(airportService.findAirportbyId(id));
    }



}


