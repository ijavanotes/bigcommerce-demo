package com.sony.bigcommerce.demo.dto.rest;

import java.io.Serializable;

public class OauthResponeDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8558974605403633354L;
	private String access_token;
	private String scope;
	private OauthUserDTO user;
	private String context;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public OauthUserDTO getUser() {
		return user;
	}
	public void setUser(OauthUserDTO user) {
		this.user = user;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
}
