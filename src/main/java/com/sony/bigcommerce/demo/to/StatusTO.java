package com.sony.bigcommerce.demo.to;

public class StatusTO {
private final int code;
private final String message;
private final String error;
public StatusTO(int code, String message, String error) {
	super();
	this.code = code;
	this.message = message;
	this.error = error;
}
public StatusTO()
{
	this.code=200;
	this.message="Success";
	this.error = null;
}
public int getCode() {
	return code;
}
public String getMessage() {
	return message;
}
public String getError() {
	return error;
}

}
