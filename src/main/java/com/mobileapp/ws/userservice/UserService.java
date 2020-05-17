package com.mobileapp.ws.userservice;

import com.mobileapp.ws.api.ui.model.response.UserRest;
import com.mobileapp.ws.api.ui.model.response.request.UsersDetailsRequestModel;

public interface UserService {
UserRest createUser(UsersDetailsRequestModel userReq);
	
}
