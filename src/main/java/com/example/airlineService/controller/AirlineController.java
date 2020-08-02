package com.example.airlineService.controller;

import com.example.airlineService.controller.request.AddAirlineRequest;
import com.example.airlineService.controller.response.AddAirlineResponse;
import com.example.airlineService.model.dto.AirlineDto;
import com.example.airlineService.service.AirlineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/airline")
public class AirlineController {
    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddAirlineResponse> addAirline(@RequestBody AddAirlineRequest request) throws Exception {
        return ResponseEntity.ok(airlineService.addAirline(request));
    }

//    @GetMapping("/findbyname")
//    public ResponseEntity

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<AirlineDto> findByid(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(airlineService.findAirlineById(id));
    }
}
