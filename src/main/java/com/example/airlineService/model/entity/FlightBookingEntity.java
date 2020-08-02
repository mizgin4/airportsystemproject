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
    @Column(name = "ROUTES_ID")
    private Long routeId;

    @Column(name = "ID_NUMBER")
    private String idNumber;

    @Column(name = "PRICE")
    private Double price;


    @Enumerated(value = EnumType.STRING)
    private FlightStatus flightStatus;



//    @ManyToMany
//    //@JoinColumn(name ="ROUTE_ID",referencedColumnName = "ROUTEID")
//    private List<RouteEntity> routeEntity;

}
