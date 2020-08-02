package com.example.airlineService.service.impl;

import com.example.airlineService.controller.request.AddRouteReqeust;
import com.example.airlineService.controller.request.SearchFlightRequest;
import com.example.airlineService.model.dto.RouteDto;
import com.example.airlineService.model.entity.AirlineEntity;
import com.example.airlineService.model.entity.RouteEntity;
import com.example.airlineService.repositroy.AirlineRepository;
import com.example.airlineService.repositroy.RouteRepository;
import com.example.airlineService.service.RouteService;

import com.example.airlineService.service.converter.RouteEntityConverter;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final AirlineRepository airlineRepository;
    private final RouteEntityConverter routeEntityConverter;

    public RouteServiceImpl(RouteRepository routeRepository, AirlineRepository airlineRepository, RouteEntityConverter routeEntityConverter) {
        this.routeRepository = routeRepository;
        this.airlineRepository = airlineRepository;
        this.routeEntityConverter = routeEntityConverter;
    }


    @Override
    public RouteDto addRoute(AddRouteReqeust request) throws Exception {
        RouteDto routeDto = new RouteDto();
        routeDto.setArrival(request.getArrival());
        routeDto.setDeparture(request.getDeparture());
        routeDto.setArrivalDate(request.getArrivalDate());
        routeDto.setDepartureDate(request.getDepartureDate());
        routeDto.setAirlineId(request.getAirlineId());
        Optional<AirlineEntity> optionalAirlineEntity=airlineRepository.findById(request.getAirlineId());
        if(!optionalAirlineEntity.isPresent()){
            throw new Exception("No airline found to be related");
        }
        AirlineEntity airlineEntity=optionalAirlineEntity.get();
        RouteEntity routeEntity=routeEntityConverter.convert(airlineEntity,routeDto);
        routeRepository.save(routeEntity);
        return routeDto;
    }

    @Override
    public RouteDto findRoutebyId(Long id) throws Exception {
        Optional<RouteEntity> optionalRouteEntity=routeRepository.findById(id);
        if(!optionalRouteEntity.isPresent()){
            throw new Exception("This route is not exitst");
        }
        return convert(optionalRouteEntity);

    }

    @Override
    public List<RouteDto> findByAirlineId(Long id) throws Exception {
        Optional<AirlineEntity> optionalAirlineEntity= airlineRepository.findById(id);
        if (!optionalAirlineEntity.isPresent()){
            throw new Exception("Related Airline Not Found");
        }
        List<RouteEntity> routeEntities=routeRepository.findByAirlineEntity(optionalAirlineEntity.get());
        return routeEntities.stream().map(this::alter).collect(Collectors.toList());

    }

    @Override
    public List<RouteDto> searchFlights(SearchFlightRequest request) {
        List<RouteEntity> routeEntity=routeRepository.findByDepartureAndArrivalAndArrivalDateAndDepartureDate(request.getDeparture(),request.getArrival(),request.getArrivalDate(),request.getDepartureDate());
        return routeEntity.stream().map(this::convertflights).collect(Collectors.toList());

    }

    private RouteDto convertflights(RouteEntity routeEntity) {
        RouteDto routeDto=new RouteDto();
        routeDto.setDeparture(routeEntity.getDeparture());
        routeDto.setArrival(routeEntity.getArrival());
        routeDto.setDepartureDate(routeEntity.getDepartureDate());
        routeDto.setArrivalDate(routeEntity.getArrivalDate());
        routeDto.setAirlineId(routeEntity.getAirlineEntity().getAirlineId());
        return routeDto;
    }

    private RouteDto alter(RouteEntity routeEntity) {
        if (routeEntity==null){
            return null;
        }
        RouteDto routeDto=new RouteDto();
        routeDto.setDeparture(routeEntity.getDeparture());
        routeDto.setArrival(routeEntity.getArrival());
        routeDto.setDepartureDate(routeEntity.getDepartureDate());
        routeDto.setArrivalDate(routeEntity.getArrivalDate());
        routeDto.setAirlineId(routeEntity.getAirlineEntity().getAirlineId());
        return routeDto;
    }

    private RouteDto convert(Optional<RouteEntity> optionalRouteEntity) {
        RouteDto routeDto=new RouteDto();
        routeDto.setArrival(optionalRouteEntity.get().getArrival());
        routeDto.setDeparture(optionalRouteEntity.get().getDeparture());
        routeDto.setArrivalDate(optionalRouteEntity.get().getArrivalDate());
        routeDto.setDepartureDate(optionalRouteEntity.get().getDepartureDate());
        return routeDto;
    }

}





