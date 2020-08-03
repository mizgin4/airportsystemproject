package com.example.airlineService.service;

import com.example.airlineService.controller.request.BookFlightRequest;
import com.example.airlineService.controller.response.BookFlightResponse;

public interface FlightBookingService {

    BookFlightResponse bookFlight(Long id, BookFlightRequest request);
}
