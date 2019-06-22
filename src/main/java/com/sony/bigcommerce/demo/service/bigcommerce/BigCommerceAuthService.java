package com.sony.bigcommerce.demo.service.bigcommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sony.bigcommerce.demo.converters.Converters;
import com.sony.bigcommerce.demo.dao.mappers.IBaseMapper;
import com.sony.bigcommerce.demo.dao.to.TbBcAuth;
import com.sony.bigcommerce.demo.dto.BaseDTO;
import com.sony.bigcommerce.demo.dto.bigcommerce.BcPayload;
import com.sony.bigcommerce.demo.dto.rest.OauthResponeDTO;
import com.sony.bigcommerce.demo.dto.rest.RestDTO;
import com.sony.bigcommerce.demo.service.rest.IRestTemplateUtil;
import com.sony.bigcommerce.demo.to.BaseResponse;

@Service("bigCommerceService")
public class BigCommerceAuthService implements IBaseService<BaseDTO<BcPayload>, BaseResponse<OauthResponeDTO>> {
	@Autowired
	IRestTemplateUtil<BcPayload> restTemplateUtil;
	@Autowired
	IBaseMapper<TbBcAuth>  tbBcAuthMapper;
	Logger logger = LoggerFactory.getLogger(BigCommerceAuthService.class);
	@Value("${bcAuthUrl}")
	private String authUrl;
	@Transactional
	@Override
	public BaseResponse<OauthResponeDTO> execute(BaseDTO<BcPayload> request) {
		logger.info(request.getResponse().getContext());
		
		RestDTO<BcPayload> restRequest = new RestDTO<BcPayload>(authUrl,
				HttpMethod.POST, request.getResponse());
		logger.info("all autherisation {}", tbBcAuthMapper.findAll());
		
		BaseResponse<OauthResponeDTO> result = restTemplateUtil.execute(restRequest,OauthResponeDTO.class,null);
		tbBcAuthMapper.insert(new TbBcAuth(Converters.stringToInteger.convert(result.getResponse().getUser().getId()), result.getResponse().getUser().getEmail(), result.getResponse().getAccess_token(),  result.getResponse().getUser().getEmail(),result.getResponse().getScope(),result.getResponse().getContext()));
		TbBcAuth tbBcAuth=  Converters.oauthResponsedtoTOtbbcAuath.convert(result.getResponse());
		tbBcAuthMapper.insert(tbBcAuth);
		//saving to database 
		logger.info("response {}", result.getResponse());
		logger.info("request object {}", request.getResponse().toString());
		return result;
		
	}

}
