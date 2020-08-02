package com.example.airlineService.service.converter.airportconv;

import com.example.airlineService.model.dto.AirportDto;
import com.example.airlineService.model.entity.AirportEntity;
import org.springframework.stereotype.Component;

@Component
public class AirportEntityConverter {

    public AirportEntity convert(AirportDto source){
        AirportEntity airportEntity=new AirportEntity();
        airportEntity.setAirportName(source.getAirportName());
        return airportEntity;
    }
}
