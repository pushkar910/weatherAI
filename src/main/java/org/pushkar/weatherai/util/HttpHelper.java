package org.pushkar.weatherai.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class HttpHelper {

	private final RestTemplate restTemplate;
	
	@Autowired
    public HttpHelper(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
    }

    public <T> ResponseEntity executeGet(String URL, HttpEntity httpEntity, T t) {
        return this.restTemplate.exchange(URL, HttpMethod.GET, httpEntity, t.getClass());
    }

    public <T> ResponseEntity executePost(String URL, HttpEntity httpEntity, T t) {
        return this.restTemplate.exchange(URL, HttpMethod.POST, httpEntity, t.getClass());
    }

    public <T> ResponseEntity executePatch(String URL, HttpEntity httpEntity, T t) {
        return this.restTemplate.exchange(URL, HttpMethod.PATCH, httpEntity, t.getClass());
    }
    
	public <T> ResponseEntity<T> exchange(String URL, HttpMethod httpMethod, HttpEntity httpEntity,
			ParameterizedTypeReference<T> responseType) {
		return restTemplate.exchange(URL, httpMethod, httpEntity, responseType);
    }
    
}
