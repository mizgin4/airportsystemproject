package com.example.airlineService;

import com.example.airlineService.model.entity.AirlineEntity;
import com.example.airlineService.repositroy.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitialRun {

    @Autowired
    private AirlineRepository airlineRepository;


    @PostConstruct
    private void postConstruct(){
        AirlineEntity airlineEntity=new AirlineEntity();
        airlineEntity.setAirlineName("THY");
        airlineRepository.save(airlineEntity);
    }

}
