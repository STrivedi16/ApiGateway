package com.ApiGateway.Response;

public class SuccessMessage {

	private String SuccessMessage;
	
	private String successKey;
	
	private Object object;

	public String getSuccessMessage() {
		return SuccessMessage;
	}

	public void setSuccessMessage(String successMessage) {
		SuccessMessage = successMessage;
	}

	public String getSuccessKey() {
		return successKey;
	}

	public void setSuccessKey(String successKey) {
		this.successKey = successKey;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public SuccessMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuccessMessage(String successMessage, String successKey, Object object) {
		super();
		SuccessMessage = successMessage;
		this.successKey = successKey;
		this.object = object;
	}
	
	
}
