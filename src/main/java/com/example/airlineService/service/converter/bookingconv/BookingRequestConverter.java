package com.example.airlineService.service.converter.bookingconv;

import com.example.airlineService.controller.request.BookFlightRequest;
import com.example.airlineService.model.dto.FlightBookingDto;
import org.springframework.stereotype.Component;

@Component
public class BookingRequestConverter {

    public FlightBookingDto convert(BookFlightRequest request) {
        FlightBookingDto flightBookingDto=new FlightBookingDto();
        flightBookingDto.setName(request.getName());
        flightBookingDto.setRouteId(request.getRouteId());
        flightBookingDto.setIdNumber(request.getIdNumber());
        flightBookingDto.setPrice(request.getPrice());
        flightBookingDto.setCartNumber(issueTicket(request.getCartNumber()));
        return flightBookingDto;
    }
    public static String issueTicket(String cardNumber){

        final int STARTLENGTH = 6;   //first digit of card  don't want to mask
        final int ENDLENGTH = 4;    //last digit of card  don't want to mask
        int maskedLength = cardNumber.length() - (STARTLENGTH + ENDLENGTH);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maskedLength; i++) {
            sb.append("*");
        }
        String maskedCard = cardNumber.substring(0, STARTLENGTH) + sb + cardNumber.substring(cardNumber.length() - ENDLENGTH, cardNumber.length());

        return maskedCard;
    }
}
