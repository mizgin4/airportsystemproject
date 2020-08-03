package com.example.airlineService.service.impl;

import com.example.airlineService.controller.request.BookFlightRequest;
import com.example.airlineService.controller.response.BookFlightResponse;
import com.example.airlineService.model.dto.FlightBookingDto;
import com.example.airlineService.model.entity.FlightBookingEntity;
import com.example.airlineService.repositroy.FlightBookingRepository;
import com.example.airlineService.service.FlightBookingService;
import com.example.airlineService.service.converter.bookingconv.BookingEntityConverter;
import com.example.airlineService.service.converter.bookingconv.BookingRequestConverter;
import org.springframework.stereotype.Service;

@Service
public class FlightBookingServiceImpl implements FlightBookingService {

    private final FlightBookingRepository flightBookingRepository;
    private final BookingRequestConverter bookingRequestConverter;
    private final BookingEntityConverter bookingEntityConverter;

    public FlightBookingServiceImpl(FlightBookingRepository flightBookingRepository, BookingRequestConverter bookingRequestConverter, BookingEntityConverter bookingEntityConverter) {
        this.flightBookingRepository = flightBookingRepository;
        this.bookingRequestConverter = bookingRequestConverter;
        this.bookingEntityConverter = bookingEntityConverter;
    }

    @Override
    public BookFlightResponse bookFlight(Long id, BookFlightRequest request) {
        FlightBookingDto flightBookingDto = bookingRequestConverter.convert(request);
        //HOW TO ISSUE THE CARD
        FlightBookingEntity flightBookingEntity = bookingEntityConverter.convert(flightBookingDto);
        flightBookingRepository.save(flightBookingEntity);
        return flightBookingResponse(flightBookingDto);

    }

    private BookFlightResponse flightBookingResponse(FlightBookingDto flightBookingDto) {
        BookFlightResponse bookFlightResponse=new BookFlightResponse();
        return null;
    }



    }
