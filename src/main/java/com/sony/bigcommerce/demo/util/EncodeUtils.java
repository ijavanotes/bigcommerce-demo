package com.sony.bigcommerce.demo.util;

import java.util.function.BiFunction;
import java.util.function.Function;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sony.bigcommerce.demo.exception.BaseRunTimeException;

public class EncodeUtils {
	static Logger logger = LoggerFactory.getLogger(EncodeUtils.class);
	public static Function<String, String> base64Decoding = (String encodedString) -> {
		
		try {
			byte[] decodedBytes = Base64.decodeBase64(encodedString) ;
			return new String(decodedBytes, "UTF-8");
		} catch (Exception e) {
			throw new BaseRunTimeException(e.getMessage());
		}

	};
	public static BiFunction<String, String, String > createHmac = (String signature, String clientSecret )-> {
		try {
			  Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		   SecretKeySpec secret_key = new SecretKeySpec(clientSecret.getBytes("UTF-8"), "HmacSHA256");
		   sha256_HMAC.init(secret_key);
		  return   Hex.encodeHexString(sha256_HMAC.doFinal(signature.getBytes("UTF-8")));
		} catch (Exception e) {
			throw new BaseRunTimeException(e.getMessage()); 
		}
		   
	};
	public static String getSingatureJson(String payload, String clientSecret)
	{
		String data [] = payload.split("\\.");
		String provided_singatrure = EncodeUtils.base64Decoding.apply(data[1]);
		String payload_object = 	 EncodeUtils.base64Decoding.apply(data[0]);
		String expected = EncodeUtils.createHmac.apply(payload_object, clientSecret);
		logger.info("singature{}", provided_singatrure);
		logger.info("expected{}",  expected);
		if (provided_singatrure.equals(expected))
		{
			return payload_object;
		}
		throw new BaseRunTimeException("The signature is wrong");
	}
	
	
	
}
