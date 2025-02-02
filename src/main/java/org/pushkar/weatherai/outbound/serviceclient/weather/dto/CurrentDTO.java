package org.pushkar.weatherai.outbound.serviceclient.weather.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CurrentDTO (
        @JsonProperty("temp_c")
        double temperatureInCelcius,
        @JsonProperty("temp_f")
        double temperatureInFahrenheit
) { }
