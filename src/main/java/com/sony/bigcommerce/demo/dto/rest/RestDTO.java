package com.sony.bigcommerce.demo.dto.rest;

import org.springframework.http.HttpMethod;

import com.sony.bigcommerce.demo.dto.BaseDTO;

public class RestDTO<T> extends BaseDTO<T> {
	private String url;
	private HttpMethod method;
	
	
	public  <V> RestDTO(String url, HttpMethod method, T body)
	{
		super(body);
		this.url= url;
		this.method= method;
	}
	public String getUrl() {
		return url;
	}
	public HttpMethod getMethod() {
		return method;
	}
	
	
	

}
