package com.sony.bigcommerce.demo.service.rest;

public enum BigCommerceURL {
CATEGORIES("/catalog/summary");
public final String url;
private BigCommerceURL(String url)
{
	this.url= url;
}
}
