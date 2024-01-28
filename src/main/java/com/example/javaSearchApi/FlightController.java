package com.example.javaSearchApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Integer id) {
        Optional<Flight> flight = flightService.getFlightById(id);
        return flight.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Flight> saveFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightService.saveFlight(flight);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Integer id, @RequestBody Flight flight) {
        if (!flightService.getFlightById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        flight.setId(id);
        Flight updatedFlight = flightService.saveFlight(flight);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Integer id) {
        if (!flightService.getFlightById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        flightService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam String departureAirport,
            @RequestParam String arrivalAirport,
            @RequestParam LocalDateTime departureDatetime,
            @RequestParam(required = false) LocalDateTime returnDatetime) {

        List<Flight> flights;

        try {
            if (returnDatetime != null) {
                // Two-way flight
                flights = flightService.findRoundTripFlights(departureAirport, arrivalAirport, departureDatetime, returnDatetime);
            } else {
                // One-way flight
                flights = flightService.findOneWayFlights(departureAirport, arrivalAirport, departureDatetime);
            }

            return new ResponseEntity<>(flights, HttpStatus.OK);
        } catch (Exception e) {

            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}