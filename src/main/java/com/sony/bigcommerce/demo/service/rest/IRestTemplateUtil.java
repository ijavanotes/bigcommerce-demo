package com.sony.bigcommerce.demo.service.rest;

import java.util.Map;

import com.sony.bigcommerce.demo.dto.rest.RestDTO;
import com.sony.bigcommerce.demo.to.BaseResponse;

public interface IRestTemplateUtil <T> {


	<R> BaseResponse<R> execute(RestDTO<T> request, Class<R> responseType, Map<String,String> headerMap);
	String getBigcommerceUrl(String context, String uri, String version);
}
