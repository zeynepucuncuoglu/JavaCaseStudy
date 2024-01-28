package com.example.javaSearchApi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    // query method for finding one-way flights
    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDatetime(
            String departureAirport, String arrivalAirport, LocalDateTime departureDatetime);

    // query method for finding round-trip flights
    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDatetimeBetween(
            String departureAirport, String arrivalAirport, LocalDateTime departureDatetime, LocalDateTime returnDatetime);
}
