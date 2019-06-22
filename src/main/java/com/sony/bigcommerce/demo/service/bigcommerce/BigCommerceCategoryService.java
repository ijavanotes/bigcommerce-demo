package com.sony.bigcommerce.demo.service.bigcommerce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sony.bigcommerce.demo.dao.mappers.IBaseMapper;
import com.sony.bigcommerce.demo.dao.to.TbBcAuth;
import com.sony.bigcommerce.demo.dto.BaseDTO;
import com.sony.bigcommerce.demo.dto.rest.RestDTO;
import com.sony.bigcommerce.demo.exception.BaseRunTimeException;
import com.sony.bigcommerce.demo.service.rest.BigCommerceURL;
import com.sony.bigcommerce.demo.service.rest.IRestTemplateUtil;
import com.sony.bigcommerce.demo.to.BaseResponse;
@Service
public class BigCommerceCategoryService implements IBaseService<BaseDTO<String>, BaseResponse<JsonNode>> {
	Logger logger = LoggerFactory.getLogger(BigCommerceCategoryService.class);
	@Autowired
	IRestTemplateUtil<String> restTemplateUtil;
	@Autowired
	IBaseMapper<TbBcAuth>  tbBcAuthMapper;
	@Override
	public BaseResponse<JsonNode> execute(BaseDTO<String> request) {
		 List<TbBcAuth>	 authList = tbBcAuthMapper.findAll();
		 if (authList != null && !authList.isEmpty())
		 {
			 Optional<TbBcAuth> last = authList.stream().reduce((first, second) -> second);
			String url =  restTemplateUtil.getBigcommerceUrl(last.get().getContext(), BigCommerceURL.CATEGORIES.url, "v3");
			logger.info(url);
			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("Content-Type", "application/json");
			headerMap.put("Accept", "application/json");
			headerMap.put("X-Auth-Client", request.getResponse());
			headerMap.put("X-Auth-Token", last.get().getAccessToken());
			RestDTO<String> restRequest = new RestDTO<String>(url,
					HttpMethod.GET, request.getResponse());
			return restTemplateUtil.execute(restRequest, JsonNode.class, headerMap);
		 }
		 throw new BaseRunTimeException("No token found");
	}

}
