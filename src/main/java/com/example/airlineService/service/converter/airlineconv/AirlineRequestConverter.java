package com.example.airlineService.service.converter.airlineconv;

import com.example.airlineService.controller.request.AddAirlineRequest;
import com.example.airlineService.model.dto.AirlineDto;
import org.springframework.stereotype.Component;

@Component
public class AirlineRequestConverter {
    public AirlineDto convert(AddAirlineRequest request){
        AirlineDto airlineDto=new AirlineDto();
        airlineDto.setAirlineName(request.getAirlineName());
        return airlineDto;
    }
}
