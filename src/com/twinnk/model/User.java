package com.twinnk.model;

public class User {
	
	public User(String emailId, String contactNumber, String password, boolean loggedInToApp,
			String deviceId) {
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.password = password;
		this.loggedInToApp = loggedInToApp;
		this.deviceId = deviceId;
	}
	/*
	 * generate at code level which is used to identify a particular user in other objects as well
	 */
	private String uniqueUserId;
	/*
	 * combination of emailId and contact number would be unique
	 */
	private String emailId;
	private String contactNumber;
	/*
	 * password should be most secure 
	 */
	private String password;
	/*
	 * determines if the user wanted auto log in
	 */
	private boolean loggedInToApp;
	/*
	 * store android device unique id (it can be changed after factory reset as well for root devices)
	 */
	private String deviceId;
	
	public String getUniqueUserId() {
		return uniqueUserId;
	}
	public String getEmailId() {
		return emailId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public boolean isLoggedInToApp() {
		return loggedInToApp;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setLoggedInToApp(boolean loggedInToApp) {
		this.loggedInToApp = loggedInToApp;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public void setUniqueUserId(String uniqueUserId) {
		this.uniqueUserId = uniqueUserId;
	}
}
