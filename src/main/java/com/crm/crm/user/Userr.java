package com.crm.crm.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class Userr {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "USER_ID")
	public Long id;

	@Column(name = "USER_NAME", unique = true, nullable = false, length = 50)
	public String userName;

	@Column(name = "USER_FIRST_NAME", nullable = false, length = 50)
    public String firstName;

	@Column(name = "USER_LAST_NAME", nullable = false, length = 50)
    public String lastName;
	
	@Column(name = "USER_EMAIL", nullable = false, length = 50)
	public String email;

	@Column(name = "USER_PASSWORD", nullable = false, length = 50)
	public String password;

	@Column(name = "USER_PHONE", nullable = false, length = 50)
	public String phone;
    

	public Userr(Long id, String userName, String firstName, String lastName, String email, String password,
			String phone) {
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public Userr() {
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


}
