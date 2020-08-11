package com.example.airlineService.service.impl;

import com.example.airlineService.controller.request.AddAirlineRequest;
import com.example.airlineService.controller.response.AddAirlineResponse;
import com.example.airlineService.model.dto.AirlineDto;
import com.example.airlineService.model.entity.AirlineEntity;
import com.example.airlineService.repositroy.AirlineRepository;
import com.example.airlineService.service.AirlineService;
import com.example.airlineService.service.converter.airlineconv.AirlineConverter;
import com.example.airlineService.service.converter.airlineconv.AirlineEntityConverter;
import com.example.airlineService.service.converter.airlineconv.AirlineRequestConverter;
import com.example.airlineService.service.exception.AirlineAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService {
    private final AirlineRepository airlineRepository;
    private final AirlineRequestConverter airlineRequestConverter;
    private final AirlineEntityConverter airlineEntityConverter;
    private final AirlineConverter airlineConverter;

    public AirlineServiceImpl(AirlineRepository airlineRepository, AirlineRequestConverter airlineRequestConverter, AirlineEntityConverter airlineEntityConverter, AirlineConverter airlineConverter) {
        this.airlineRepository = airlineRepository;
        this.airlineRequestConverter = airlineRequestConverter;
        this.airlineEntityConverter = airlineEntityConverter;
        this.airlineConverter = airlineConverter;
    }


    @Override
    public AddAirlineResponse addAirline(AddAirlineRequest request) throws Exception {
        Optional<AirlineEntity> optionalAirlineEntity = Optional.ofNullable(airlineRepository.findByAirlineName(request.getAirlineName()));

        if(optionalAirlineEntity.isPresent()){
            throw new AirlineAlreadyExistException(request.getAirlineName());
        }
        AirlineDto airlineDto=airlineRequestConverter.convert(request);
        AirlineEntity airlineEntity=airlineEntityConverter.convert(airlineDto);
        airlineRepository.save(airlineEntity);

        return getResponse(airlineDto);
    }

    @Override
    public AirlineDto findAirlineById(Long id) throws Exception {
        Optional<AirlineEntity> airlineEntity=airlineRepository.findById(id);
        if (!airlineEntity.isPresent()){
            throw new Exception("Airline not found");
        }
        return airlineConverter.convert(airlineEntity);
    }

    private AddAirlineResponse getResponse(AirlineDto airlineDto) {
        AddAirlineResponse response=new AddAirlineResponse();
        response.setAirlineName(airlineDto.getAirlineName());
        return response;
    }
}
