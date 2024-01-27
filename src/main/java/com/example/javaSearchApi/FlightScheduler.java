package com.example.javaSearchApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Component
public class FlightScheduler {

    @Autowired
    private FlightService flightService;

    @Autowired
    private RestTemplate restTemplate;

    //@Scheduled(fixedRate = 1000)
    @Scheduled(cron = "0 0 12 * * ?")
    public void scheduleFlightApiRequest() {
        // Mock data for creating a new Flight entity
        Flight newFlight = new Flight();
        newFlight.setDepartureAirport("JFK");
        newFlight.setArrivalAirport("LAX");
        newFlight.setDepartureDatetime(LocalDateTime.now());
        newFlight.setReturnDatetime(LocalDateTime.now().plusDays(2));

        // Set Content-Type header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create an HttpEntity with headers and body
        HttpEntity<Flight> requestEntity = new HttpEntity<>(newFlight, headers);

        // Make a POST request to the /flights endpoint
        String apiUrl = "http://localhost:8080/flights";
        Flight savedFlight = restTemplate.postForObject(apiUrl, requestEntity, Flight.class);
        System.out.println("Scheduled Task - Flight created and saved: " + savedFlight);
        // You can optionally use the savedFlight returned by the API, log it, or perform other actions.
    }
}