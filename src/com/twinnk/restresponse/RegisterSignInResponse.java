package com.twinnk.restresponse;

public class RegisterSignInResponse extends BaseResponse{

	private String uniqueId;
	public RegisterSignInResponse(String uniqueId){
		this.setUniqueId(uniqueId);
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
}