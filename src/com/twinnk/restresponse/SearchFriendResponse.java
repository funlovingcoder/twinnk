package com.twinnk.restresponse;

import com.twinnk.model.UserDetails;

public class SearchFriendResponse extends BaseResponse {

	private UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
