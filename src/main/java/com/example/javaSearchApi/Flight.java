package com.example.javaSearchApi;






import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "departure_airport")
    private String departureAirport;

    @Column(name = "arrival_airport")
    private String arrivalAirport;

    @Column(name = "departure_datetime")
    private LocalDateTime departureDatetime;

    @Column(name = "return_datetime")
    private LocalDateTime returnDatetime;

    private Double price;

    // Constructors, getters, and setters

    public Flight(Integer id, String departureAirport, String arrivalAirport, LocalDateTime departureDatetime, LocalDateTime returnDatetime, Double price) {
        this.id = id;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDatetime = departureDatetime;
        this.returnDatetime = returnDatetime;
        this.price = price;
    }

    public Flight() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getDepartureDatetime() {
        return departureDatetime;
    }

    public void setDepartureDatetime(LocalDateTime departureDatetime) {
        this.departureDatetime = departureDatetime;
    }

    public LocalDateTime getReturnDatetime() {
        return returnDatetime;
    }

    public void setReturnDatetime(LocalDateTime returnDatetime) {
        this.returnDatetime = returnDatetime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
