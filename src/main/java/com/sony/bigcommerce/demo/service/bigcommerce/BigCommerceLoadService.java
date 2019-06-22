package com.sony.bigcommerce.demo.service.bigcommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sony.bigcommerce.demo.dto.BaseDTO;
import com.sony.bigcommerce.demo.dto.rest.SignedPayloadDTO;
import com.sony.bigcommerce.demo.to.BaseResponse;
import com.sony.bigcommerce.demo.to.StatusTO;
import com.sony.bigcommerce.demo.util.EncodeUtils;
@Service
public class BigCommerceLoadService implements IBaseService<BaseDTO<String>, BaseResponse<SignedPayloadDTO>>{
	Logger logger = LoggerFactory.getLogger(BigCommerceLoadService.class);
	@Value("${bcClientSecret}")
	private String clientSecret;


	@Autowired
	private JsonServiceUtil jsonUtil;

	public BaseResponse<SignedPayloadDTO> execute(BaseDTO<String> request) {
		logger.info("data {}", request.getResponse());
		String json = EncodeUtils.getSingatureJson(request.getResponse(), clientSecret);
		logger.info("json load{}", json);
		SignedPayloadDTO response = jsonUtil.convertJsonToObject(json, SignedPayloadDTO.class);
		return new BaseResponse<SignedPayloadDTO>(response, new StatusTO());
	}
	

	

}
