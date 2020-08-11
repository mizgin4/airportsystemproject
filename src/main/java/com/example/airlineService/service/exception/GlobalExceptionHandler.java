package com.example.airlineService.service.exception;

import com.example.airlineService.controller.request.AddAirlineRequest;
import com.example.airlineService.controller.response.AddAirlineResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AirlineAlreadyExistException.class)
    public ResponseEntity<Object> airlineExistHandler(AirlineAlreadyExistException ex,WebRequest request){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Airline is already exist");

        return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);

    }
    @ExceptionHandler(AirlineNotFoundException.class)
    public ResponseEntity<Object> airlineNotFoundHandler(AirlineNotFoundException ex,WebRequest request){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Airline is not exist");

        return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);

    }


}
