package com.example.airlineService.service.converter.airportconv;

import com.example.airlineService.controller.request.AddAirportRequest;
import com.example.airlineService.model.dto.AirportDto;
import org.springframework.stereotype.Component;

@Component
public class AirportRequestConverter {

    public AirportDto convert(AddAirportRequest request){
        AirportDto airportDto=new AirportDto();
        airportDto.setAirportName(request.getAirportName());
        return airportDto;
    }
}
