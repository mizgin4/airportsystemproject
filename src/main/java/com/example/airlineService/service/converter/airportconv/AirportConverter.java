package com.example.airlineService.service.converter.airportconv;

import com.example.airlineService.model.dto.AirlineDto;
import com.example.airlineService.model.dto.AirportDto;
import com.example.airlineService.model.entity.AirportEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class AirportConverter {

    public AirportDto convert(Optional<AirportEntity> source){
        AirportDto airportDto=new AirportDto();
        airportDto.setAirportName(source.get().getAirportName());
        return airportDto;

    }

}
