package org.pushkar.weatherai.outbound.serviceclient.weather.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConditionDTO {

    private String text;
    private String icon;
    private int code;
}
