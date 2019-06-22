package com.sony.bigcommerce.demo.config;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.sony.bigcommerce.demo.service.rest.RestTemplateLogs;
@Configuration
@ConfigurationProperties(prefix = "rest.connection")
public class ApplicationConfig {
	Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);
	private int timout;
	@Bean
	public  ClientHttpRequestFactory getClientHttpRequestFactory() {
	   logger.info("timeout " + timout);
	    HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
	    httpRequestFactory.setConnectionRequestTimeout(timout);
	    httpRequestFactory.setReadTimeout(timout);
	    return httpRequestFactory;
	}
	@Bean RestTemplate restTemplate()
	{
		RestTemplate restTemplate = new 		RestTemplate(new BufferingClientHttpRequestFactory( getClientHttpRequestFactory()));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new RestTemplateLogs());
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}
	public void setTimout(int timout) {
		this.timout = timout;
	}
	
}
