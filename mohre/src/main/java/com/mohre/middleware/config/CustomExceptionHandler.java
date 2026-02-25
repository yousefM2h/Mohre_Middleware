package com.mohre.middleware.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class CustomExceptionHandler implements ResponseErrorHandler {
	
	private List<HttpStatus> acceptableStatus;

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		acceptableStatus = Arrays.stream("OK,NOT_ACCEPTABLE".split(","))
                .map(HttpStatus::valueOf)
                .collect(Collectors.toList()) ;
        return !acceptableStatus.contains(response.getStatusCode());
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
