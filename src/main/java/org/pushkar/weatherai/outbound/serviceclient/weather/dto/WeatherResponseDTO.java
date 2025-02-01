package org.pushkar.weatherai.outbound.serviceclient.weather.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherResponseDTO {

    private LocationDTO location;
    private CurrentDTO current;
}
