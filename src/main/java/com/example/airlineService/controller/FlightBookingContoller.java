package com.example.airlineService.controller;

import com.example.airlineService.controller.request.BookFlightRequest;
import com.example.airlineService.controller.request.SearchFlightRequest;
import com.example.airlineService.controller.response.BookFlightResponse;
import com.example.airlineService.model.dto.RouteDto;
import com.example.airlineService.service.FlightBookingService;
import com.example.airlineService.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightBookingContoller {

    private final RouteService routeService;

    private final FlightBookingService flightBookingService;

    public FlightBookingContoller(RouteService routeService, FlightBookingService flightBookingService) {
        this.routeService = routeService;
        this.flightBookingService = flightBookingService;
    }


    @GetMapping("/searchflight")
    public ResponseEntity<List<RouteDto>> searchFlights(@RequestBody SearchFlightRequest request){
        return ResponseEntity.ok(routeService.searchFlights(request));
    }

    @PostMapping("/reservation/{id}")
    public ResponseEntity<BookFlightResponse> bookFlight(@PathVariable Long id ,@RequestBody BookFlightRequest request){
        return ResponseEntity.ok(flightBookingService.bookFlight(id,request));
    }
}
