package com.sony.bigcommerce.demo.to;

public interface IBaseResponse  <T> {
	 T getResponse();
	 StatusTO getStatus();
	 
}
