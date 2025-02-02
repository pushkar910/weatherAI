package org.pushkar.weatherai.config;

import org.pushkar.weatherai.outbound.serviceclient.weather.dto.WeatherRequestDTO;
import org.pushkar.weatherai.outbound.serviceclient.weather.dto.WeatherResponseDTO;
import org.pushkar.weatherai.service.WeatherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class FunctionConfig {


    @Bean
    @Description("Get the current weather conditions for the given city.")
    public Function<WeatherRequestDTO, WeatherResponseDTO> currentWeatherFunction() {
        return new WeatherService();
    }
}
