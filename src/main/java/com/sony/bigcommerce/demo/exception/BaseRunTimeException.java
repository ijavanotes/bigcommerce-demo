package com.sony.bigcommerce.demo.exception;

import com.sony.bigcommerce.demo.to.StatusTO;

public class BaseRunTimeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4649629056838292831L;
	private StatusTO status;
	public BaseRunTimeException() {
		super();
		status = new StatusTO(500,null,"Error");
	}

	public BaseRunTimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		status = new StatusTO(500,null,message);
	}

	public BaseRunTimeException(String message, Throwable cause) {
		super(message, cause);
		status = new StatusTO(500,null,message);
	}

	public BaseRunTimeException(String message) {
		super(message);
		status = new StatusTO(500,null,message);
	}

	public BaseRunTimeException(Throwable cause) {
		super(cause);
		status = new StatusTO(500,null,cause != null ?cause.getMessage(): "Error");
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public StatusTO getStatus() {
		return status;
	}
	

}
