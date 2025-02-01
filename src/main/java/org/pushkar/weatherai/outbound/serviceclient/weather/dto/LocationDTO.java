package org.pushkar.weatherai.outbound.serviceclient.weather.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDTO implements Serializable {

    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;
    @JsonProperty("tz_id")
    private String tzId;
    @JsonProperty("localtime_epoch")
    private long localtimeEpoch;
    private String localtime;
}
