package com.twinnk.utility;
import java.util.UUID;

public class TwinnkUtility {

	public GenerateUUID generateUUID = new GenerateUUID();
	public String generateUniqueUserId(String emailId, String contactNumber) {
		return emailId.substring(0, emailId.indexOf('@')) + contactNumber;
	}

	public class GenerateUUID {

		public UUID getUniqueId(){
			return UUID.randomUUID();
		}
	}
}
