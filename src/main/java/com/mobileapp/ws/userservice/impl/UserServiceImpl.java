package com.mobileapp.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mobileapp.ws.api.ui.model.response.UserRest;
import com.mobileapp.ws.api.ui.model.response.request.UsersDetailsRequestModel;
import com.mobileapp.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {
	Map<String, UserRest> user;
	@Override
	public UserRest createUser(UsersDetailsRequestModel userReq) {
		
		UserRest returnUser = new UserRest();
		returnUser.setEmail(userReq.getEmail());
		returnUser.setFirstName(userReq.getFirstName());
		returnUser.setLastName(userReq.getLastName());
		
		
		String userId = UUID.randomUUID().toString();
		returnUser.setUserId(userId);
		if (user == null)user = new HashMap<>();
		
		user.put(userId, returnUser);
		
		
		
		return returnUser;
	}
}