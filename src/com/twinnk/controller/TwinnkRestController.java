package com.twinnk.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.twinnk.model.UserDetails;
import com.twinnk.restresponse.BaseResponse;
import com.twinnk.restresponse.RegisterSignInResponse;
import com.twinnk.restresponse.SearchFriendResponse;
import com.twinnk.service.TwinnkService;

@RestController
@RequestMapping(value="/api")
public class TwinnkRestController {
	@Autowired
	private TwinnkService service;
	
	private static final Logger logger = Logger.getLogger(TwinnkRestController.class);
	
	@RequestMapping(value="/registerUser")
	public @ResponseBody BaseResponse registerUser(@RequestParam(value="firstName") String firstName , @RequestParam(value="lastName") String lastName, @RequestParam(value="mobileNumber") String mobileNumber, @RequestParam(value="emailId") String emailId, @RequestParam(value="password") String password){
		BaseResponse baseResponse;
		if(service.emailAlreadyExist(emailId)){
			baseResponse = new BaseResponse();
			baseResponse.setStatus(15);
			baseResponse.setMessage("EmailId already registered!!!");
			return baseResponse;
		}else{
			String uuid = service.registerUser(firstName, lastName, mobileNumber, emailId, password);
			if(uuid == null){
				//failed to register user
				baseResponse = new BaseResponse();
				baseResponse.setStatus(14);
				baseResponse.setMessage("Unable to register User!!!");
				return baseResponse;
			}
			baseResponse = new RegisterSignInResponse(uuid);
		}
		return baseResponse;
	}
 
	@RequestMapping(value = "/autoSignInUser")
	public @ResponseBody BaseResponse autoSignInUser(@RequestParam(value="uniqueId") String uniqueId){
		BaseResponse baseResponse = new BaseResponse();
		if(!service.getUserDetailFromDeviceId(uniqueId)){
			baseResponse.setStatus(14);
			baseResponse.setMessage("Unable to log in by device Id!!!");
		}
		return baseResponse;
	}	
	
	@RequestMapping(value = "/signInUser")
	public @ResponseBody BaseResponse signInUser(@RequestParam(value="emailId") String emailId, @RequestParam(value="password") String password){
		BaseResponse baseResponse;
		String uuid = service.signInUser(emailId, password);
		if(uuid == null || uuid == ""){
			baseResponse = new BaseResponse();
			baseResponse.setStatus(14);
			baseResponse.setMessage("Invalid emailId or Password!!!");
			return baseResponse;
		}
		baseResponse = new RegisterSignInResponse(uuid);
		return baseResponse;
	}
	
	@RequestMapping(value="/updateUserLocation")
	public @ResponseBody BaseResponse updateUserLocation(@RequestParam(value="latitude") String latitude, @RequestParam(value="longitude") String longitude, @RequestParam(value="uniqueId") String uniqueId, @RequestParam(value="timeStamp") String timeStamp){
		BaseResponse baseResponse = new BaseResponse();
		System.out.println("latitude : " + latitude + " longitude : " + longitude + " uniqueId : " + uniqueId + " timeStamp : " + timeStamp);
		if(!service.updateUserLocation(latitude, longitude, uniqueId, timeStamp)){
			baseResponse.setStatus(14);
			baseResponse.setMessage("Unable to save Location!!!");
		}
		return baseResponse;
	}
	
	@RequestMapping(value="searchFriend")
	public @ResponseBody BaseResponse searchFriend(@RequestParam(value="searchString") String searchString){
		BaseResponse baseResponse;
		UserDetails userDetails = service.searchFriend(searchString);
		if(userDetails != null){
			SearchFriendResponse friendResponse = new SearchFriendResponse();
			friendResponse.setUserDetails(userDetails);
			baseResponse = friendResponse;
		}else{
			baseResponse = new BaseResponse();
			baseResponse.setStatus(14);
			baseResponse.setMessage("No result found...!!!");
		}
		return baseResponse;
	}
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody BaseResponse handleError(HttpServletRequest req, Exception exception) {
		logger.debug("Request: " + req.getRequestURL() + " raised " + exception);
		BaseResponse baseResponse = new BaseResponse(exception.getMessage(), 120);
		return baseResponse;
	}
	/*@RequestMapping("/fetchCntacts")
	public List<UserDetails> fetchCntacts(@RequestParam(value="userId") String userId){
		return service.fetchCntacts(userId);
	}
	
	@RequestMapping("/doLogIn")
	public boolean doLogIn(@RequestParam(value="userId") String userId,@RequestParam(value="password")  String password){
		return service.doLogIn(userId, password);
	}
	
	@RequestMapping(value = "/createAccount")
	public BaseResponse createAccount(@RequestParam(value="emailId") String emailId, @RequestParam(value="contactNumber") String contactNumber, @RequestParam(value="password") String password, @RequestParam(value="loggedInToApp") boolean loggedInToApp, @RequestParam(value="deviceId") String deviceId){
		User user = new User(emailId, contactNumber, password, loggedInToApp, deviceId);
		return service.createAccount(user);
	}
	
	@RequestMapping("/fetchUserDetails")
	public UserDetails fetchUserDetails(@RequestParam(value="userId") String userId){
		return service.fetchUserDetails(userId);
	}
	
	@RequestMapping("/setUserDetails")
	public boolean setUserDetails(){
		return service.setUserDetails(null);
	}
	
	@RequestMapping("/twinnkByOthers")
	public boolean twinnkByOthers(@RequestParam(value="userId") String userId, @RequestParam(value="property") boolean property){
		return service.twinnkByOthers(userId, property);
	}
	
	@RequestMapping("/twinnkOthers")
	public boolean twinnkOthers(@RequestParam(value="userId") String userId, @RequestParam(value="property") boolean property){
		return service.twinnkOthers(userId, property);
	}
	
	@RequestMapping("/setContactStatus")
	public boolean setContactStatus(@RequestParam(value="userId") String userId, @RequestParam(value="contactId") String contactId, @RequestParam(value="status") String status){
		return service.setContactStatus(userId, contactId, status);
	}
	
	@RequestMapping("/changePassword")
	public boolean changePassword(@RequestParam(value="userId") String userId, @RequestParam(value="userId") String password){
		return service.changePassword(userId, password);
	}
	
	@RequestMapping("/twinnkSomeone")
	public boolean twinnkSomeone(@RequestParam(value="userId") String userid, @RequestParam(value="contactId") String contactId, @RequestParam(value="message") String message, @RequestParam(value="locationOfTwinnk") String locationOfTwinnk){
		return service.twinnkSomeone(userid, contactId, message, locationOfTwinnk);
	}*/
	
	//If any exception occurred in this particular controller this will handle that

}
