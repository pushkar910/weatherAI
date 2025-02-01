package org.pushkar.weatherai.outbound.serviceclient.weather.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrentDTO {

    private long last_updated_epoch;
    private String last_updated;
    @JsonProperty("temp_c")
    private double temperatureInCelcius;
    @JsonProperty("temp_f")
    private double temperatureInFahrenheit;
    private int is_day;
    private ConditionDTO condition;
    private double wind_mph;
    private double wind_kph;
    private int wind_degree;
    private String wind_dir;
    private int pressure_mb;
    private double pressure_in;
    private double precip_mm;
    private double precip_in;
    private int humidity;
    private int cloud;
    private double feelslike_c;
    private double feelslike_f;
    private double windchill_c;
    private double windchill_f;
    private double heatindex_c;
    private double heatindex_f;
    private double dewpoint_c;
    private double dewpoint_f;
    private int vis_km;
    private int vis_miles;
    private int uv;
    private double gust_mph;
    private double gust_kph;
}
