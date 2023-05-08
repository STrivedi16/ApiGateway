package com.ApiGateway.model;

public class JwtResponse {

	String token;
	
	String reftoken;

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

	public JwtResponse(String token, String reftoken) {
		super();
		this.token = token;
		this.reftoken = reftoken;
	}

	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
