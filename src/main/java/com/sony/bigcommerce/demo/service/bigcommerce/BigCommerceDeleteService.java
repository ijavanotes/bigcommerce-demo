package com.sony.bigcommerce.demo.service.bigcommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sony.bigcommerce.demo.converters.Converters;
import com.sony.bigcommerce.demo.dao.mappers.IBaseMapper;
import com.sony.bigcommerce.demo.dao.to.TbBcAuth;
import com.sony.bigcommerce.demo.dto.BaseDTO;
import com.sony.bigcommerce.demo.dto.rest.SignedPayloadDTO;
import com.sony.bigcommerce.demo.to.BaseResponse;
import com.sony.bigcommerce.demo.to.StatusTO;
import com.sony.bigcommerce.demo.util.EncodeUtils;
@Service("deleteService")
public class BigCommerceDeleteService implements IBaseService<BaseDTO<String>, BaseResponse<SignedPayloadDTO>>{
	Logger logger = LoggerFactory.getLogger(BigCommerceDeleteService.class);
	@Value("${bcClientSecret}")
	private String clientSecret;
	@Autowired
	IBaseMapper<TbBcAuth>  tbBcAuthMapper;

	@Autowired
	private JsonServiceUtil jsonUtil;
	public BaseResponse<SignedPayloadDTO> execute(BaseDTO<String> request) {
		logger.info("data {}" , request.getResponse() );
		String json = EncodeUtils.getSingatureJson(request.getResponse(), clientSecret);
		logger.info("json load{}", json);
			SignedPayloadDTO response = 	jsonUtil.convertJsonToObject(json, SignedPayloadDTO.class);
			try{
			TbBcAuth tbBcAuth = new TbBcAuth();
			tbBcAuth.setId(Converters.stringToInteger.convert(response.getOwner().getId()));
			tbBcAuthMapper.delete(tbBcAuth);
			}
			catch (Throwable e)
			{
				logger.error("error while deleter from db{}", e);
				
			}
			return new BaseResponse<SignedPayloadDTO>(response, new StatusTO());
		}  
		
	

	

}
