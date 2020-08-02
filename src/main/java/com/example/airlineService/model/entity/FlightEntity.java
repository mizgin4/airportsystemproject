package com.example.airlineService.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @OneToOne
    private RouteEntity routeEntity;

    private Double price;
}
