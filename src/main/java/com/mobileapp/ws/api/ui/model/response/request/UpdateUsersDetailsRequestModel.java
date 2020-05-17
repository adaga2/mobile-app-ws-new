package com.mobileapp.ws.api.ui.model.response.request;

import javax.validation.constraints.NotNull;

public class UpdateUsersDetailsRequestModel {
	@NotNull(message = "first name should not be empty")
	private String firstName;
	@NotNull(message = "last name should not be empty")
	private String lastName;
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
}
