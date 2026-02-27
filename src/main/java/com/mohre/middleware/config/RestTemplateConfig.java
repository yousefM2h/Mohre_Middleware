package com.mohre.middleware.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
//	@Bean
//    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate(
//                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
//        
//        restTemplate.setInterceptors(Collections.singletonList(new RestTemplateInterceptor()));
//        
//        restTemplate.setErrorHandler(new CustomExceptionHandler());
//
//        return restTemplate;
//    }
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
