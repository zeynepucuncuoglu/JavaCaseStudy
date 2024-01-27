package com.example.javaSearchApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Integer id) {
        return flightRepository.findById(id);
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(Integer id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> findRoundTripFlights(String departureAirport, String arrivalAirport, LocalDateTime departureDatetime, LocalDateTime returnDatetime) {
        // Placeholder logic - replace with actual logic
        // Example: Find round-trip flights based on the given parameters
        return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDatetimeBetween(
                departureAirport, arrivalAirport, departureDatetime, returnDatetime);
    }

    public List<Flight> findOneWayFlights(String departureAirport, String arrivalAirport, LocalDateTime departureDatetime) {
        // Placeholder logic - replace with actual logic
        // Example: Find one-way flights based on the given parameters
        return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDatetime(
                departureAirport, arrivalAirport, departureDatetime);
    }
}
