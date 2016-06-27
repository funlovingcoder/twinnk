package com.twinnk.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.twinnk.dao.TwinnkDao;
import com.twinnk.model.User;
import com.twinnk.model.UserDetails;
import com.twinnk.restresponse.BaseResponse;
import com.twinnk.utility.TwinnkUtility;

public class TwinnkServiceImpl implements TwinnkService {
	@Autowired
	private TwinnkDao dao;
	@Autowired
	private TwinnkUtility utility;

	@Override
	public boolean getUserDetailFromDeviceId(String uniqueId) {
		if(dao.getUserDetailFromDeviceId(uniqueId) == 1)
			return true;
		return false;
	}

	@Override
	public List<UserDetails> fetchCntacts(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doLogIn(String userId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BaseResponse createAccount(User user) {
		user.setUniqueUserId(utility.generateUniqueUserId(user.getEmailId(), user.getContactNumber()));
		Object[] objects = new Object[] { user.getUniqueUserId(), user.getEmailId(), user.getContactNumber(), user.getPassword(), user.getDeviceId() };
		return dao.createAccount(user, objects);
	}

	@Override
	public UserDetails fetchUserDetails(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setUserDetails(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean twinnkByOthers(String userId, boolean property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean twinnkOthers(String userId, boolean property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setContactStatus(String userId, String contactId, String status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(String userId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean twinnkSomeone(String userid, String contactId, String message, String locationOfTwinnk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String registerUser(String firstName, String lastName, String mobileNumber, String emailId, String password) {
		String uuid = String.valueOf(utility.generateUUID.getUniqueId());
		if(!dao.registerUser(firstName, lastName, mobileNumber, emailId, password, uuid)){
			return null;
		}
		return uuid;
	}

	@Override
	public String signInUser(String emailId, String password) {
		return dao.signInUser(emailId, password);
	}

	@Override
	public boolean updateUserLocation(String latitude, String longitude, String uniqueId, String timeStamp) {
		return dao.updateUserLocation(latitude, longitude, uniqueId, timeStamp);
	}

	@Override
	public boolean emailAlreadyExist(String emailId) {
		return dao.emailAlreadyExist(emailId) != 0 ? true : false;
	}

	@Override
	public UserDetails searchFriend(String searchString) {
		return dao.searchFriend(searchString);
	}
}