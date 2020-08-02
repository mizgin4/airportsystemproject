package com.example.airlineService.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AIRLINE")
public class AirlineEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AIRLINE_ID")
    private Long airlineId;

    @Column(name = "AIRLINE_NAME")
    private String airlineName;

    @OneToMany(mappedBy = "airlineEntity")
    private List<RouteEntity> routeEntities;

    public Long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Long alirlineId) {
        this.airlineId = alirlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
}
