package com.example.airlineService.service.converter.airlineconv;

import com.example.airlineService.model.dto.AirlineDto;
import com.example.airlineService.model.entity.AirlineEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class AirlineConverter {
    public AirlineDto convert (Optional<AirlineEntity> source){
        AirlineDto airlineDto=new AirlineDto();
        airlineDto.setAirlineName(source.get().getAirlineName());
        airlineDto.setAlirlineId(source.get().getAirlineId());
        return airlineDto;

    }
}
