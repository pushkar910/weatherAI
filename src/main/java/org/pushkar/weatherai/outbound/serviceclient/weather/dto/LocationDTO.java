package org.pushkar.weatherai.outbound.serviceclient.weather.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LocationDTO(
        String name,
        String region,
        String country,
        double lat,
        double lon) implements Serializable { }
