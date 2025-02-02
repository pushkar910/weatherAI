package org.pushkar.weatherai.service;

import org.pushkar.weatherai.outbound.serviceclient.weather.client.WeatherClient;
import org.pushkar.weatherai.outbound.serviceclient.weather.client.impl.WeatherClientImpl;
import org.pushkar.weatherai.outbound.serviceclient.weather.dto.WeatherRequestDTO;
import org.pushkar.weatherai.outbound.serviceclient.weather.dto.WeatherResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.function.Function;

@Service
public class WeatherService implements Function<WeatherRequestDTO, WeatherResponseDTO> {

    @Autowired
    private WeatherClient weatherClient;

    @Override
    public WeatherResponseDTO apply(WeatherRequestDTO weatherRequest) {
        return weatherClient.getWeather(weatherRequest.city());
    }

}
