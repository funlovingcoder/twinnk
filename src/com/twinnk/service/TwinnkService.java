package com.twinnk.service;

import java.util.List;

import com.twinnk.model.User;
import com.twinnk.model.UserDetails;
import com.twinnk.restresponse.BaseResponse;

public interface TwinnkService {

	public boolean getUserDetailFromDeviceId(String uniqueId);
	public List<UserDetails> fetchCntacts(String userId);
	public boolean doLogIn(String userId, String password);
	public BaseResponse createAccount(User user);
	public UserDetails fetchUserDetails(String userId);
	public boolean setUserDetails(UserDetails userDetails);
	public boolean twinnkByOthers(String userId, boolean property);
	public boolean twinnkOthers(String userId, boolean property);
	public boolean setContactStatus(String userId, String contactId, String status);
	public boolean changePassword(String userId, String password);
	public boolean twinnkSomeone(String userid, String contactId, String message, String locationOfTwinnk);
	public String registerUser(String firstName, String lastName, String mobileNumber, String emailId, String password);
	public String signInUser(String emailId, String password);
	public boolean updateUserLocation(String latitude, String longitude, String uniqueId, String timeStamp);
	public boolean emailAlreadyExist(String emailId);
	public UserDetails searchFriend(String searchString);

}
