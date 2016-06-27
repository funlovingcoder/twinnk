package com.twinnk.model;

public class UserConfiguration {

	private String uniqueUserId;
	/*
	 * this is setting you can on/off to notify you hat you can twinnk someone
	 */
	private boolean twinnkNear;
	/*
	 * user allow others to get twinnnked
	 */
	private boolean twinnkAllow;
	/*
	 * set auto twinnk level
	 * country
	 * state
	 * city/village
	 * colony/place/nearby
	 */
	private String twinnkLimit;
	/*
	 * wnats to be twinnked atyour home location
	 */
	private boolean homeTwinnk;
	
	public boolean isHomeTwinnk() {
		return homeTwinnk;
	}
	public void setHomeTwinnk(boolean homeTwinnk) {
		this.homeTwinnk = homeTwinnk;
	}
	public String getTwinnkLimit() {
		return twinnkLimit;
	}
	public void setTwinnkLimit(String twinnkLimit) {
		this.twinnkLimit = twinnkLimit;
	}
	public String getUniqueUserId() {
		return uniqueUserId;
	}
	public boolean isTwinnkNear() {
		return twinnkNear;
	}
	public boolean isTwinnkAllow() {
		return twinnkAllow;
	}
	public void setTwinnkNear(boolean twinnkNear) {
		this.twinnkNear = twinnkNear;
	}
	public void setTwinnkAllow(boolean twinnkAllow) {
		this.twinnkAllow = twinnkAllow;
	}
	public void setUniqueUserId(String uniqueUserId) {
		this.uniqueUserId = uniqueUserId;
	}
}
