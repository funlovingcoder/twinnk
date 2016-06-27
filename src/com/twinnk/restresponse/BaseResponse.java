package com.twinnk.restresponse;

public class BaseResponse {

	private int status;
	private String message;
	
	public BaseResponse(){
		this.status = 200;
		this.message = "OK";
	}
	
	public BaseResponse(String message, int status) {
		super();
		this.status = status;
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
