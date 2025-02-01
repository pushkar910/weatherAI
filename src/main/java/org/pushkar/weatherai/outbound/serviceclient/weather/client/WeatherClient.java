package org.pushkar.weatherai.outbound.serviceclient.weather.client;

import org.pushkar.weatherai.outbound.serviceclient.weather.dto.WeatherResponseDTO;

public interface WeatherClient {

    WeatherResponseDTO getWeather(String cityName);
}
