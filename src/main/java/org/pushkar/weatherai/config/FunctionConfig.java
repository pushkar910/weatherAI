package org.pushkar.weatherai.config;

import org.pushkar.weatherai.outbound.serviceclient.weather.client.WeatherClient;
import org.pushkar.weatherai.outbound.serviceclient.weather.dto.WeatherResponseDTO;
import org.pushkar.weatherai.service.WeatherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class FunctionConfig {

    private final WeatherClient weatherClient;

    public FunctionConfig(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @Bean
    @Description("get weather of a city")
    Function<String, WeatherResponseDTO> getWeather() {
        return new WeatherService(weatherClient);
    }
}
