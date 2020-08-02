package com.example.airlineService.model.entity;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ROUTE")
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROUTEID")
    private Long routeId;
    @Column(name = "DEPARTURE")
    private String departure;
    @Column(name = "ARRIVAL")
    private String arrival;
    @Column(name = "DEPARTUREDATE")
    private LocalDate departureDate;
    @Column(name = "ARRIVALDATE")
    private LocalDate arrivalDate;

    @Column(name = "PRICE")
    private Double price;


    @ManyToOne
    @JoinColumn(name = "AIRLINE_ID",referencedColumnName = "AIRLINE_ID")
    private AirlineEntity airlineEntity;

    @OneToOne
    private FlightEntity flightEntity;

//    @ManyToMany(mappedBy = "routeEntity")
//    private List<FlightBookingEntity> flightBookingEntities;


    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public AirlineEntity getAirlineEntity() {
        return airlineEntity;
    }

    public void setAirlineEntity(AirlineEntity airlineEntity) {
        this.airlineEntity = airlineEntity;
    }
}
