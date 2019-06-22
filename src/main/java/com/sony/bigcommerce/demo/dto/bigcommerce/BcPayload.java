package com.sony.bigcommerce.demo.dto.bigcommerce;

public class BcPayload {
	private final String code ;
	private final String scope;
	private final String context;
	private final String client_id;
	private final String client_secret;
	private final String grant_type;
	private final String redirect_uri;
	private BcPayload (BcPayLoadBuilder builder)
	{
		this.code= builder.code;
		this.scope= builder.scope;
		this.context = builder.context;
		this.client_id = builder.client_id;
		this.client_secret = builder.client_secret;
		this.grant_type = builder.grant_type;
		this.redirect_uri = builder.redirect_uri;
	}
	
 public static class BcPayLoadBuilder{
	 private final String code ;
		private final String scope;
		private final String context;
		private String client_id;
		private  String client_secret;
		private  String grant_type="authorization_code";
		private  String redirect_uri;
		public BcPayLoadBuilder(String code, String scope, String context)
		{
			this.code= code;
			this.scope=scope;
			this.context =context;
		}
		public BcPayLoadBuilder  client_id(String client_id)
		{
			this.client_id= client_id;
			return this;
			
		}
		public BcPayLoadBuilder client_secret(String client_secret)
		{
			this.client_secret = client_secret;
			return this;
		}
		public BcPayLoadBuilder grant_type(String grant_type)
		{
			this.grant_type = grant_type;
			return this;
		}
		public BcPayLoadBuilder redirect_uri(String redirect_uri)
		{
			this.redirect_uri = redirect_uri;
			return this;
		}
		public BcPayload build()
		{
		return new BcPayload(this);	
		}
	
}
	public String getCode() {
		return code;
	}
	public String getScope() {
		return scope;
	}
	public String getContext() {
		return context;
	}
	
	public String getClient_id() {
		return client_id;
	}
	public String getClient_secret() {
		return client_secret;
	}
	public String getGrant_type() {
		return grant_type;
	}
	public String getRedirect_uri() {
		return redirect_uri;
	}
	@Override
	public String toString() {
		return "BcPayload [code=" + code + ", scope=" + scope + ", context=" + context + ", client_id=" + client_id
				+ ", client_secret=" + client_secret + ", grant_type=" + grant_type + ", redirect_uri=" + redirect_uri
				+ "]";
	}

}
