package org.pushkar.weatherai.outbound.serviceclient.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherRequestDTO(String city) { }
