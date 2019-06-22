package com.sony.bigcommerce.demo.dto;

public  class BaseDTO<T> implements IBaseDTO<T> {
	private T response;

	public BaseDTO(T response) {
		this.response = response;
	}
	@Override
	public T getResponse() {
		return response;
	}
}
