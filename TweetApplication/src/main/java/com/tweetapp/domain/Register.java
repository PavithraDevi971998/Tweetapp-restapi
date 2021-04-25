package com.tweetapp.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Register {
	@Id
	private int id;
	@Size(min=2,message="First Name should have atleast 3 characters")
	private String firstName;
	@Size(min=2,message="Last Name should have atleast 3 characters")
	private String lastName;
	@Email(message = "Email should be valid")
	private String email;
	@NotNull(message = "Password cannot be null")
	private String password;
	@NotNull(message = "Confirm Password cannot be null")
	private String confirmpwd;
	@NotNull(message = "Contact Number cannot be null")
	private String contactNo;
	public Register(int id, @Size(min = 2, message = "First Name should have atleast 3 characters") String firstName,
			@Size(min = 2, message = "Last Name should have atleast 3 characters") String lastName,
			@Email(message = "Email should be valid") String email,
			@NotNull(message = "Password cannot be null") String password,
			@NotNull(message = "Confirm Password cannot be null") String confirmpwd,
			@NotNull(message = "Contact Number cannot be null") String contactNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmpwd = confirmpwd;
		this.contactNo = contactNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getConfirmpwd() {
		return confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "Register [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", confirmpwd=" + confirmpwd + ", contactNo=" + contactNo + "]";
	}
	
	

}
