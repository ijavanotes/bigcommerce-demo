package com.sony.bigcommerce.demo.service.bigcommerce;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sony.bigcommerce.demo.exception.BaseRunTimeException;
@Service
public class JsonServiceUtil {
	Logger logger = LoggerFactory.getLogger(JsonServiceUtil.class);
	@Autowired
	private ObjectMapper jacksonObjectMapper;
	public <T> T convertJsonToObject(String json , Class<T> ojectToResponse)
	{
		try {
			T response = 	jacksonObjectMapper.readValue(json, ojectToResponse);
			return response;
		} catch (JsonParseException e) {
			logger.error("error parsing{}", e);
			throw new BaseRunTimeException("error parsing");
			
		} catch (JsonMappingException e) {
			logger.error("error parsing{}", e);
			throw new BaseRunTimeException("error parsing");
		
		} catch (IOException e) {
			logger.error("error parsing{}", e);
			throw new BaseRunTimeException("error parsing");
		
		}
	}
	public String convertObjectToJson(Object obj)
	{
		try {
			return jacksonObjectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			logger.error("error converting json to object{}", e);
			throw new BaseRunTimeException("error parsing");
		}
	}

}
