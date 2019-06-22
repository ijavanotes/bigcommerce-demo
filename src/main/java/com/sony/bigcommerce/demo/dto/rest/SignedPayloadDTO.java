package com.sony.bigcommerce.demo.dto.rest;

public class SignedPayloadDTO {
	private OauthUserDTO user;
	private OauthUserDTO owner;
	private String context;
	private String store_hash;
	private float timestamp;
	public OauthUserDTO getUser() {
		return user;
	}
	public void setUser(OauthUserDTO user) {
		this.user = user;
	}
	public OauthUserDTO getOwner() {
		return owner;
	}
	public void setOwner(OauthUserDTO owner) {
		this.owner = owner;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getStore_hash() {
		return store_hash;
	}
	public void setStore_hash(String store_hash) {
		this.store_hash = store_hash;
	}
	public float getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(float timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
