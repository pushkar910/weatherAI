package org.pushkar.weatherai.controller;

import org.pushkar.weatherai.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {


    private final WeatherService weatherService;

    WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping
    public Double getCurrentWeather(@RequestParam String city) {
        return weatherService.apply(city).getCurrent().getTemperatureInCelcius();
    }

}
