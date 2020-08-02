package com.example.airlineService.service.converter.airlineconv;

import com.example.airlineService.model.dto.AirlineDto;
import com.example.airlineService.model.entity.AirlineEntity;

import org.springframework.stereotype.Component;

@Component
public class AirlineEntityConverter {

    public AirlineEntity convert(AirlineDto source) throws Exception{

        if(source==null){
            throw new  Exception("No source found");
        }

        AirlineEntity airlineEntity=new AirlineEntity();
        airlineEntity.setAirlineName(source.getAirlineName());
        return airlineEntity;

    }
}
