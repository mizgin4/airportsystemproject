package com.example.airlineService.model.entity;

import com.example.airlineService.model.enums.FlightStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "FLIGHT_BOOKING")
public class FlightBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FLIGHT_ID")
    private Long flightId;

    @Column(name = "PASSENGER_NAME")
    private String name;

    @Column(name = "CART_NUMBER")
    private String cartNumber;

    //Route Id releation ile bagli degil bunun degistirilmesi gerekebilir.
    @Column(name = "ROUTE_ID")
    private Long routeId;

    @Column(name = "ID_NUMBER")
    private String idNumber;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.STRING)
    private FlightStatus flightStatus;

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    //    @ManyToMany
//    //@JoinColumn(name ="ROUTE_ID",referencedColumnName = "ROUTEID")
//    private List<RouteEntity> routeEntity;

}
