package com.twinnk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.twinnk.model.User;
import com.twinnk.model.UserDetails;
import com.twinnk.restresponse.BaseResponse;

public class TwinnkDaoImpl implements TwinnkDao {
	@Autowired
	DataSource dataSource;

	@Override
	public int getUserDetailFromDeviceId(String uniqueId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);	
		return jdbcTemplate.queryForInt("SELECT count(*) FROM User WHERE uniqueUserId = (?)", new Object[]{uniqueId});
	}

	@Override
	public List<UserDetails> fetchCntacts(String userId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return null;
	}

	@Override
	public boolean doLogIn(String userId, String password) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return false;
	}

	@Override
	public BaseResponse createAccount(User user, Object[] objects) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);	
		BaseResponse baseResponse = new BaseResponse("User Created", 200);
		String sql = "INSERT INTO User "  
				+ "(uniqueUserId,emailId, contactNumber, password, deviceId) "
				+"VALUES (?, ?, ?, ?, ? )";  

		int rows = jdbcTemplate.update( sql, objects);  
		if(rows == 0){
			baseResponse.setMessage("Error Occurred !!!");
			baseResponse.setStatus(1674);
		}
		return baseResponse;
	}

	@Override
	public UserDetails fetchUserDetails(String userId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return null;
	}

	@Override
	public boolean setUserDetails(UserDetails userDetails) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return false;
	}

	@Override
	public boolean twinnkByOthers(String userId, boolean property) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return false;
	}

	@Override
	public boolean twinnkOthers(String userId, boolean property) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return false;
	}

	@Override
	public boolean setContactStatus(String userId, String contactId, String status) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return false;
	}

	@Override
	public boolean changePassword(String userId, String password) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return false;
	}

	@Override
	public boolean twinnkSomeone(String userid, String contactId, String message, String locationOfTwinnk) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return false;
	}

	@Override
	public boolean registerUser(String firstName, String lastName, String mobileNumber, String emailId, String password, String uuid) {
		JdbcTemplate jdbcTemplate  = new JdbcTemplate(dataSource);
		int rowCount = jdbcTemplate.update("INSERT INTO User (firstName, lastName, mobileNumber, emailId, password, uniqueUserId) VALUES (?, ?, ?, ?, ?, ?)", new Object[]{firstName, lastName, mobileNumber, emailId, password, uuid});
		if(rowCount > 0){
			return true; 
		}
		return false;
	}

	@Override
	public String signInUser(String emailId, String password) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<String> uniqueUserIds = jdbcTemplate.query("SELECT uniqueUserId FROM User WHERE emailId = (?) AND password =(?)", new Object[]{emailId, password}, new RowMapper<String>() {
			 
	        @Override
	        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
	            return rs.getString("uniqueUserId");
	        }
	 
	    });
		try{
			return uniqueUserIds.get(0);
		}catch(Exception e){
			System.out.println("Error : " + e.getMessage());
			return null;
		}
	}

	@Override
	public boolean updateUserLocation(String latitude, String longitude, String uniqueId, String timeStamp) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//update query
		int rowCount = jdbcTemplate.update("UPDATE UserLocation set currentLatitude=(?), currentLongitude=(?), timeStamp =(?) WHERE uniqueUserId = (?)", new Object[]{latitude, longitude, timeStamp, uniqueId });
		if(rowCount == 0){
			rowCount = jdbcTemplate.update("INSERT INTO UserLocation (currentLatitude, currentLongitude, timeStamp, uniqueUserId) VALUES (?, ?, ?, ?)", new Object[]{latitude, longitude, timeStamp, uniqueId});
			if(rowCount == 0){
				return false;
			}
		}
		return true;
	}

	@Override
	public int emailAlreadyExist(String emailId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//int rowCount = jdbcTemplate.query("SELECT uniqueUserId FROM User WHERE emailId = (?)", new Object[]{});
		return jdbcTemplate.queryForInt("SELECT count(*) FROM User WHERE emailId = (?) Group By emailId", new Object[]{emailId});
	}

	@Override
	public UserDetails searchFriend(String searchString) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<UserDetails> uniqueUserIds = jdbcTemplate.query("SELECT firstName, lastName, emailId, mobileNumber FROM User WHERE emailId = (?) OR mobileNumber =(?)", new Object[]{searchString, searchString}, new RowMapper<UserDetails>() {
			 
	        @Override
	        public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	UserDetails userDetails = new UserDetails();
	        	userDetails.setFirstName(rs.getString("firstName"));
	        	userDetails.setLastName(rs.getString("lastName"));
	        	userDetails.setEmailId(rs.getString("emailId"));
	        	//userDetails.setMobileNumber(rs.getString("mobileNumber"));
	        	return userDetails;
	        	//return rs.getString("uniqueUserId");
	        }
	 
	    });
		return uniqueUserIds.size()>0 ? uniqueUserIds.get(0) : null;
	}
}
