package org.pushkar.weatherai.config;

import org.pushkar.weatherai.service.JobsService;
import org.pushkar.weatherai.service.WeatherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class FunctionConfig {


    @Bean
    @Description("Get the current weather conditions for the given city.")
    public Function<WeatherService.Request,WeatherService.Response> currentWeatherFunction() {
        return new WeatherService();
    }

    @Bean
    @Description("Get the latest jobs for the given keyword.")
    public Function<JobsService.Request,JobsService.Response> fetchJobsRelatedToKeyword() {
        return new JobsService();
    }
}
