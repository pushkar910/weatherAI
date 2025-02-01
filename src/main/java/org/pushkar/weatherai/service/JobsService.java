package org.pushkar.weatherai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.function.Function;

@Service
public class JobsService implements Function<JobsService.Request, JobsService.Response> {


    @Value("${job.api.key}")
    private String API_KEY;

    private static final String JOB_API_URL = "https://linkedin-api8.p.rapidapi.com";

    private final RestClient restClient;

    public JobsService() {
        this.restClient = RestClient.create(JOB_API_URL);
    }

    @Override
    public JobsService.Response apply(JobsService.Request request) {
        return restClient.get()
                .uri("/search-jobs-v2?keywords=${keyword}&locationId=92000000&datePosted=anyTime&sort=mostRelevant&start=0", request.keyword)
                .header("x-rapidapi-key", API_KEY)
                .header("x-rapidapi-host", "linkedin-api8.p.rapidapi.com")
                .retrieve()
                .body(JobsService.Response.class);
    }

    public record Request(String keyword) {}

    public record Response(
            boolean success,
            String message,
            List<Data> data,
            int total
    ){}
    public record Data(
            String id,
            String title,
            String url,
            String referenceId,
            String posterId,
            Company company,
            String location,
            String postAt,
            long postedTimestamp
    ){}
    public record Company(
            String id,
            String name,
            String logo,
            String url,
            StaffCountRange staffCountRange,
            Headquarter headquarter
    ){}
    public record StaffCountRange(
            String min,
            String max
    ){}
    public record Headquarter(
            String city,
            String country
    ){}
}
