package com.sony.bigcommerce.demo.service.bigcommerce;

import com.sony.bigcommerce.demo.dto.BaseDTO;
import com.sony.bigcommerce.demo.to.BaseResponse;

@SuppressWarnings("rawtypes")
public interface IBaseService < T extends BaseDTO, R extends BaseResponse> {
	R execute(T request) ; 

}
