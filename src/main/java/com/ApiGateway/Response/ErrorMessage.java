package com.ApiGateway.Response;

public class ErrorMessage {

	private String errorMessage;
	
	private String errorKey;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}

	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(String errorMessage, String errorKey) {
		super();
		this.errorMessage = errorMessage;
		this.errorKey = errorKey;
	}
	
	
}
