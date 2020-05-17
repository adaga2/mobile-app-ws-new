package com.mobileapp.ws.api.ui.model.response.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class UsersDetailsRequestModel {
	@NotNull(message = "first name should not be empty")
	private String firstName;
	@NotNull(message = "last name should not be empty")
	private String lastName;
	@NotNull(message = "email should not be empty")
	@Email
	private String email;
	@NotNull(message = " User Id should not be empty")
	// @Size(min=6)
	@NotNull(message = "Password should not be empty")
	@Size(max = 8, min = 4)
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}