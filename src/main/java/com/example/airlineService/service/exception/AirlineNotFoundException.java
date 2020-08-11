package com.example.airlineService.service.exception;

public class AirlineNotFoundException extends RuntimeException {

    public AirlineNotFoundException(Long airlineId) {
        super(String.format("Airline with id %d already exist",airlineId));
    }
}
