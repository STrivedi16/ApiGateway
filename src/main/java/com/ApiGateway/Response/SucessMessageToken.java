package com.ApiGateway.Response;

public class SucessMessageToken {

	private String successMessage;
	
	private String successKey;
	
	private String token;
	
	private String reftoken;

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getSuccessKey() {
		return successKey;
	}

	public void setSuccessKey(String successKey) {
		this.successKey = successKey;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getReftoken() {
		return reftoken;
	}

	public void setReftoken(String reftoken) {
		this.reftoken = reftoken;
	}

	public SucessMessageToken(String successMessage, String successKey, String token, String reftoken) {
		super();
		this.successMessage = successMessage;
		this.successKey = successKey;
		this.token = token;
		this.reftoken = reftoken;
	}

	public SucessMessageToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
