package com.interview.airline.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.interview.airline.models.FlightModel;
import com.interview.airline.services.FlightDataService;

@RestController
public class AirlinesController {
    @GetMapping("/DeltaAirline")
    public List<FlightModel> getDeltaAirlines() throws IOException, InterruptedException, URISyntaxException{
        FlightDataService flightDataService = new FlightDataService();
        List<FlightModel> flightList = flightDataService.getFlightData();
        List<FlightModel> filteredFlightList = new ArrayList<FlightModel>();

        for (FlightModel flight : flightList) {
            if(flight.airline.equals("Delta Air Lines")){
                System.out.println(flight.airline);
                filteredFlightList.add(flight);
            }
        }

        return filteredFlightList;
    }
}
