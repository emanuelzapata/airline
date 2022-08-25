package com.interview.airline.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.airline.models.FlightModel;

public class FlightDataService {
    private HttpClient client = HttpClient.newHttpClient();

    public List<FlightModel> getFlightData() throws IOException, InterruptedException, URISyntaxException{
        HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI("https://cdn.kiqa.flyaa.aa.com/apiv2/mobile-microservice-starter/api/flights/v1.0.0"))
        .GET()
        .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        ObjectMapper mapper = new ObjectMapper();

        List<FlightModel> flightList = mapper.readValue(response.body(), new TypeReference<List<FlightModel>>(){});

        return flightList;
    }
}
