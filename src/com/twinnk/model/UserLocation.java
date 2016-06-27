package com.twinnk.model;

public class UserLocation {

	private String uniqueUserId;
	/*
	 * home location set for user
	 */
	private String homeLocationLat;
	private String homeLocationLong;
	/*
	 * current location of user will be store in this
	 */
	private String currentLocationLat;
	private String currentLocationLong;
	
	public String getUniqueUserId() {
		return uniqueUserId;
	}
	public void setUniqueUserId(String uniqueUserId) {
		this.uniqueUserId = uniqueUserId;
	}
	public String getHomeLocationLat() {
		return homeLocationLat;
	}
	public void setHomeLocationLat(String homeLocationLat) {
		this.homeLocationLat = homeLocationLat;
	}
	public String getHomeLocationLong() {
		return homeLocationLong;
	}
	public void setHomeLocationLong(String homeLocationLong) {
		this.homeLocationLong = homeLocationLong;
	}
	public String getCurrentLocationLat() {
		return currentLocationLat;
	}
	public void setCurrentLocationLat(String currentLocationLat) {
		this.currentLocationLat = currentLocationLat;
	}
	public String getCurrentLocationLong() {
		return currentLocationLong;
	}
	public void setCurrentLocationLong(String currentLocationLong) {
		this.currentLocationLong = currentLocationLong;
	}
}
