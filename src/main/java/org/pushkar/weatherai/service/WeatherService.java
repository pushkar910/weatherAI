package org.pushkar.weatherai.service;

import lombok.RequiredArgsConstructor;
import org.pushkar.weatherai.outbound.serviceclient.weather.client.WeatherClient;
import org.pushkar.weatherai.outbound.serviceclient.weather.dto.WeatherResponseDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class WeatherService implements Function<String, WeatherResponseDTO> {

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @Override
    public WeatherResponseDTO apply(String city) {
        return weatherClient.getWeather(city);
    }
}
