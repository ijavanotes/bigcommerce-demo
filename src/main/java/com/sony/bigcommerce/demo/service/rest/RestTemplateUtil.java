package com.sony.bigcommerce.demo.service.rest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sony.bigcommerce.demo.dto.rest.RestDTO;
import com.sony.bigcommerce.demo.exception.BaseRunTimeException;
import com.sony.bigcommerce.demo.to.BaseResponse;
import com.sony.bigcommerce.demo.to.StatusTO;
@Service
public class RestTemplateUtil< T>  implements  IRestTemplateUtil<T>  {
	Logger logger = LoggerFactory.getLogger(RestTemplateUtil.class);
	@Autowired
	private RestTemplate restRemplate;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Value("${bcApiUrl}")
	private String apiUrl;
	
	@SuppressWarnings("unchecked")
	@Override
	public <R> BaseResponse<R> execute(RestDTO<T> request, Class<R> responseType,  Map<String,String> headerMap) {
		try{
			HttpHeaders headers = new HttpHeaders();
			if (headerMap != null && !headerMap.isEmpty())
			{
				headerMap.forEach((k,v)-> headers.add(k, v));
					
			}
			
			@SuppressWarnings("rawtypes")
			HttpEntity<T> entity = new HttpEntity( request.getResponse() , headers);
			ResponseEntity<R> restResponse = restRemplate.exchange(request.getUrl(), request.getMethod(), entity,  responseType);
			
			return  new BaseResponse<R>(restResponse.getBody(), new StatusTO());
			}
			catch (RestClientException e)
			{
				logger.error("Error on connecting rest call {}", e);
				throw new BaseRunTimeException(e);
				
			}
		}
	@Override
	public String getBigcommerceUrl(String context, String uri,  String version) {
		String url = String.join("/", apiUrl, context, version, uri);
		return url;
	}
			

				
	
	
	

}
 