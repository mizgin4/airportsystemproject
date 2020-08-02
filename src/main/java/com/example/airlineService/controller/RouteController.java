package com.example.airlineService.controller;

import com.example.airlineService.controller.request.AddRouteReqeust;
import com.example.airlineService.model.dto.RouteDto;
import com.example.airlineService.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/add")
    public ResponseEntity<RouteDto> addRoute(@RequestBody AddRouteReqeust routeReqeust) throws Exception{
        return ResponseEntity.ok(routeService.addRoute(routeReqeust));
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<RouteDto> findRouteById(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(routeService.findRoutebyId(id));
    }

    @GetMapping("findbyairlineid/{id}")
    public ResponseEntity<List<RouteDto>> findByAirlineId(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(routeService.findByAirlineId(id));
    }

}
