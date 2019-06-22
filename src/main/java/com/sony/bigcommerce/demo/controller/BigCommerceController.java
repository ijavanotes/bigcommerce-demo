package com.sony.bigcommerce.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.sony.bigcommerce.demo.dto.BaseDTO;
import com.sony.bigcommerce.demo.dto.bigcommerce.BcPayload;
import com.sony.bigcommerce.demo.dto.rest.OauthResponeDTO;
import com.sony.bigcommerce.demo.dto.rest.SignedPayloadDTO;
import com.sony.bigcommerce.demo.service.bigcommerce.IBaseService;
import com.sony.bigcommerce.demo.service.bigcommerce.JsonServiceUtil;
import com.sony.bigcommerce.demo.to.BaseResponse;

@Controller
public class BigCommerceController {
	Logger logger = LoggerFactory.getLogger(BigCommerceController.class);
	@Value("${bcClientId}")
	private String bcClientId;
	@Value("${bcClientSecret}")
	private String bcClientSecret;
	@Value("${bcAuthUrl}")
	private String bcAuthUrl;
	@Value("${crmAppUrl}")
	private String crmAppUrl;
	@Value("${auth}")
	private String auth;
	@Value("${load}")
	private String load;

	
	
	@Autowired 
	IBaseService<BaseDTO<BcPayload>, BaseResponse<OauthResponeDTO>> service;
	@Autowired
	IBaseService<BaseDTO<String>, BaseResponse<SignedPayloadDTO>> bigCommerceLoadService;
	@Autowired
	private JsonServiceUtil jsonUtil;
	@Autowired
	private IBaseService<BaseDTO<String>, BaseResponse<JsonNode>> bigCommerceCategorySrrvice;
	@Autowired()
	@Qualifier("deleteService")
	private  IBaseService<BaseDTO<String>, BaseResponse<SignedPayloadDTO>> bigcommerceDeleteService;
	
	@RequestMapping("/auth")
	public  String home(Model model, @RequestParam(name = "code", required = false) String code,  @RequestParam(name="scope", required = false) String scope, @RequestParam(name="context", required = false)String context) {
		BaseDTO<BcPayload> request = new BaseDTO<BcPayload>(new BcPayload.BcPayLoadBuilder(code, scope, context).client_id( bcClientId).client_secret(bcClientSecret).redirect_uri(crmAppUrl + auth) .build()  );
		logger.info(code);
		logger.info(scope);
		logger.info(context);
		 BaseResponse<OauthResponeDTO> response = service.execute(request);
		 String json = jsonUtil.convertObjectToJson(response.getResponse().getUser());
		model.addAttribute("data_json", json);
		return  "auth";
	}
	@RequestMapping("/load")
	public String load(Model model , @RequestParam(name="signed_payload") String signedPayload)
	{
		logger.info("signed payload {}" , signedPayload);
		BaseDTO<String> request = new BaseDTO<String>(signedPayload);
		 BaseResponse<SignedPayloadDTO> payload = bigCommerceLoadService.execute(request);
		 String json = jsonUtil.convertObjectToJson(payload);
		 model.addAttribute("data_json", json);
		 logger.info("payload {}", payload);
		return "load";
	}
	@RequestMapping("/uninstall")
	public String uninstall(Model model, @RequestParam(name="signed_payload") String signedPayload)
	{
		logger.info("signed payload{}" , signedPayload);
		BaseDTO<String> request = new BaseDTO<String>(signedPayload);
		bigcommerceDeleteService.execute(request);
	    logger.info("successfull uninstall apps" );
		return "uninstall";
	}
	@RequestMapping("/product/catalog")
	public  @ResponseBody BaseResponse<JsonNode> getCatalogue()
	{
		BaseDTO<String> request = new BaseDTO<String>(bcClientId);
		return bigCommerceCategorySrrvice.execute(request);
	}
}
