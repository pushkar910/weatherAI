package org.pushkar.weatherai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.function.Function;

@Service
public class WeatherService implements Function<WeatherService.Request, WeatherService.Response> {


    @Value("${weather.api.key}")
    private String API_KEY;

    private static final String WEATHER_API_URL = "https://api.weatherapi.com/v1";

    private final RestClient restClient;

    public WeatherService() {
        this.restClient = RestClient.create(WEATHER_API_URL);
    }

    @Override
    public Response apply(Request weatherRequest) {
        return restClient.get()
                .uri("/current.json?key={key}&q={q}", API_KEY, weatherRequest.city())
                .retrieve()
                .body(Response.class);
    }

    // mapping the response of the Weather API to records. I only mapped the information I was interested in.
    public record Request(String city) {}
    public record Response(Location location,Current current) {}
    public record Location(String name, String region, String country, Long lat, Long lon){}
    public record Current(String temp_c, Condition condition, String wind_mph, String humidity) {}
    public record Condition(String text){}

}
