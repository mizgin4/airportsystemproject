package com.example.airlineService.service.exception;

public class AirlineAlreadyExistException extends RuntimeException {

    public AirlineAlreadyExistException(String airlineName){
        super(String.format("Airline with name %d already exist",airlineName));
    }

}
