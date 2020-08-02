package com.example.airlineService.service.impl;

import com.example.airlineService.controller.request.AddAirportRequest;
import com.example.airlineService.controller.response.AddAirportResponse;
import com.example.airlineService.model.dto.AirportDto;
import com.example.airlineService.model.entity.AirportEntity;
import com.example.airlineService.repositroy.AirportRepository;
import com.example.airlineService.service.AirportService;
import com.example.airlineService.service.converter.airportconv.AirportConverter;
import com.example.airlineService.service.converter.airportconv.AirportEntityConverter;
import com.example.airlineService.service.converter.airportconv.AirportRequestConverter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;
    private final AirportRequestConverter airportRequestConverter;
    private final AirportEntityConverter airportEntityConverter;
    private final AirportConverter airportConverter;

    public AirportServiceImpl(AirportRepository airportRepository, AirportRequestConverter airportRequestConverter, AirportEntityConverter airportEntityConverter, AirportConverter airportConverter) {
        this.airportRepository = airportRepository;
        this.airportRequestConverter = airportRequestConverter;
        this.airportEntityConverter = airportEntityConverter;
        this.airportConverter = airportConverter;
    }

    @Override
    public AddAirportResponse addAirport(AddAirportRequest request) throws Exception {
        Optional<AirportEntity> optionalAirportEntity= Optional.ofNullable(airportRepository.findByAirportName(request.getAirportName()));
        if (optionalAirportEntity.isPresent()){
            throw new Exception("This Airport Already Exist");
        }
        AirportDto airportDto=airportRequestConverter.convert(request);
        AirportEntity airportEntity=airportEntityConverter.convert(airportDto);
        airportRepository.save(airportEntity);
        return getResponse(airportDto);
    }

    @Override
    public AirportDto findAirportbyId(Long id) throws Exception {
        Optional<AirportEntity> airportEntity=airportRepository.findById(id);
        if (!airportEntity.isPresent()){
            throw new Exception("Airport not exist");
        }
        return airportConverter.convert(airportEntity);
    }

    private AddAirportResponse getResponse(AirportDto airportDto) {
        AddAirportResponse addAirportResponse=new AddAirportResponse();
        addAirportResponse.setAirportName(airportDto.getAirportName());
        return addAirportResponse;
    }
}
