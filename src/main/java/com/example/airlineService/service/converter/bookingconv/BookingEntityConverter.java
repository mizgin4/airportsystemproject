package com.example.airlineService.service.converter.bookingconv;

import com.example.airlineService.model.dto.FlightBookingDto;
import com.example.airlineService.model.entity.FlightBookingEntity;
import org.springframework.stereotype.Component;

@Component
public class BookingEntityConverter {

    public FlightBookingEntity convert(FlightBookingDto flightBookingDto) {
        FlightBookingEntity flightBookingEntity=new FlightBookingEntity();
        flightBookingEntity.setName(flightBookingDto.getName());
        flightBookingEntity.setCartNumber(flightBookingDto.getCartNumber());
        flightBookingEntity.setIdNumber(flightBookingDto.getIdNumber());
        flightBookingEntity.setPrice(flightBookingDto.getPrice());
        return flightBookingEntity;
    }
}
