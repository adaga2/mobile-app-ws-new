package com.mobileapp.ws.api.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;
import com.mobileapp.ws.api.ui.controller.ExceptionHandler.CustomException;
import com.mobileapp.ws.api.ui.model.response.UserRest;
import com.mobileapp.ws.api.ui.model.response.request.UpdateUsersDetailsRequestModel;
import com.mobileapp.ws.api.ui.model.response.request.UsersDetailsRequestModel;
import com.mobileapp.ws.userservice.UserService;
import com.mobileapp.ws.userservice.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserCotroller {
	Map<String, UserRest> user;
	
	@Autowired
	UserService userService;
	

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get-user-called-page=" + page + " and limit =" + limit + " and sort = " + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		/* if(true)throw new CustomException("A Custom Message"); */
		
		if (user.containsKey(userId)) {
			return new ResponseEntity<>(user.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE }, 
			
			produces = {
			MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UsersDetailsRequestModel userReq)
	

	{

		UserRest returnUser = userService.createUser(userReq);
		
		
		
		
		return new ResponseEntity<UserRest>(returnUser, HttpStatus.OK);

	}

	@PutMapping(path = "/{userId}",consumes = { MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE }, 
			
			produces = {
			MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE })
	public UserRest UpdateUser(@PathVariable String userId,@Valid @RequestBody UpdateUsersDetailsRequestModel userReq) {
		
		UserRest StoreUserDetail=user.get(userId);
		StoreUserDetail.setFirstName(userReq.getFirstName());
		StoreUserDetail.setLastName(userReq.getLastName());
		user.put(userId, StoreUserDetail);
		
		return StoreUserDetail;
	}

	@DeleteMapping(path="/{id}")
	public ResponseEntity <Void> DeleteUser(@PathVariable String id) {
		user.remove(id);
		return ResponseEntity.noContent().build();
	}

}
