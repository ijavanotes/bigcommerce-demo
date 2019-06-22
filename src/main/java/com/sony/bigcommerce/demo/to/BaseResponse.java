package com.sony.bigcommerce.demo.to;

public class BaseResponse<T> implements IBaseResponse<T> {
	private T response;
	private StatusTO statusTO;

	public BaseResponse(T response, StatusTO statusTO) {
		this.response = response;
		this.statusTO = statusTO;
	}

	@Override
	public T getResponse() {
		return response;
	}

	@Override
	public StatusTO getStatus() {
		return statusTO;
	}
}
