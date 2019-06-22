package com.sony.bigcommerce.demo.dao.to;

public class TbBcAuth {
private int id;
private String userName;
private String accessToken;
private String useremail;
private String scope;
private String context;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getAccessToken() {
	return accessToken;
}
public void setAccessToken(String accessToken) {
	this.accessToken = accessToken;
}
public String getUseremail() {
	return useremail;
}
public void setUseremail(String useremail) {
	this.useremail = useremail;
}
public String getScope() {
	return scope;
}
public void setScope(String scope) {
	this.scope = scope;
}
public String getContext() {
	return context;
}
public void setContext(String context) {
	this.context = context;
}
public TbBcAuth()
{
	
}
public TbBcAuth(int id, String userName, String accessToken, String useremail, String scope, String context) {
	super();
	this.id = id;
	this.userName = userName;
	this.accessToken = accessToken;
	this.useremail = useremail;
	this.scope = scope;
	this.context = context;
}


}
