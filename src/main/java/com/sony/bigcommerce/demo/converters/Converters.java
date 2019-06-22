package com.sony.bigcommerce.demo.converters;

import com.sony.bigcommerce.demo.dao.to.TbBcAuth;
import com.sony.bigcommerce.demo.dto.rest.OauthResponeDTO;

public class Converters {

	public static  IConvertrs<String, Integer> stringToInteger = (from) -> Integer.valueOf(from);
	public static IConvertrs<OauthResponeDTO, TbBcAuth> oauthResponsedtoTOtbbcAuath = (from )->{
		TbBcAuth tbBcAuth = new TbBcAuth();
		tbBcAuth.setAccessToken(from.getAccess_token());
		tbBcAuth.setContext(from.getContext());
		tbBcAuth.setId(stringToInteger.convert(from.getUser().getId()));
		tbBcAuth.setUseremail(from.getUser().getEmail());
		tbBcAuth.setUseremail(from.getUser().getEmail());
		tbBcAuth.setScope(from.getScope());
		
		return tbBcAuth;
	};

}
