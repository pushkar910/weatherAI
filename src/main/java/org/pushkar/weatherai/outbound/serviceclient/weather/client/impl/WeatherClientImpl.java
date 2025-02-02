package org.pushkar.weatherai.outbound.serviceclient.weather.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.pushkar.weatherai.outbound.serviceclient.weather.client.WeatherClient;
import org.pushkar.weatherai.outbound.serviceclient.weather.dto.WeatherResponseDTO;
import org.pushkar.weatherai.util.HttpHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;


@Component
@Slf4j
public class WeatherClientImpl implements WeatherClient {

    @Value("${weather.api.key}")
    private String API_KEY;

    private static final String WEATHER_API_URL = "https://api.weatherapi.com/v1/current.json?q=${CITY_NAME}&key=${API_KEY}";

    @Autowired
    private HttpHelper httpHelper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public WeatherResponseDTO getWeather(String cityName) {
        try {
            String url = WEATHER_API_URL.replace("${CITY_NAME}", cityName);
            url = url.replace("${API_KEY}", API_KEY);
            ResponseEntity<Map<String, Object>> response = httpHelper.executeGet(url, null, new LinkedHashMap<String, Object>());
            if (response != null) {
                Map<String, Object> metadata = response.getBody();
                if (null != metadata && response.getStatusCode() == HttpStatus.OK) {
                    WeatherResponseDTO weatherResponseDTO = objectMapper.convertValue(metadata, WeatherResponseDTO.class);
                    log.info("City: {} and Weather response: {}",cityName, weatherResponseDTO);
                    return weatherResponseDTO;
                }
            }
        } catch (Exception e) {
            log.error("Error while fetching weather for city: {}", cityName, e);
        }
        return null;
    }
}
