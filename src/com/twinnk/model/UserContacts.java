package com.twinnk.model;

public class UserContacts {

	/*
	 * current user's id
	 */
	private String uniqueUserId;
	/*
	 * id of contact current user is added
	 */
	private String uniqueFriendId;
	/*
	 * block any particular user to not get twinnk from
	 */
	private String status;
	
	public String getUniqueFriendId() {
		return uniqueFriendId;
	}
	public void setUniqueFriendId(String uniqueFriendId) {
		this.uniqueFriendId = uniqueFriendId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUniqueUserId() {
		return uniqueUserId;
	}
	public void setUniqueUserId(String uniqueUserId) {
		this.uniqueUserId = uniqueUserId;
	}
}
