package com.cg.ems.entity;

import java.util.ArrayList;

//import java.util.List;
import java.util.Set;

//import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {

	@Id
	// @Pattern(regexp = "[a-zA-Z0-9]{1,100}", message = "Name can't be Empty")
	@Column(name = "user_name")
	private String userName;
	// @Pattern(regexp = "[a-zA-Z0-9]{1,100}", message = "Name can't be Empty")
	@Column(name = "user_first_name")
	private String userFirstName;
	// @Pattern(regexp = "[a-zA-Z0-9]{1,100}", message = "Name can't be Empty")
	@Column(name = "user_last_name")
	private String userLastName;

	@Column(name = "user_password")
	private String userPassword;
	// @Pattern(regexp = "[0-9]{10}", message = "Number entered is not an valid
	// number")
	private long mobileNumber;

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

//	@OneToMany(mappedBy = "user")
//
//	private List<Booking> bookingList = new ArrayList<Booking>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID")

	})
	private Set<Role> role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userPassword=" + userPassword + ", mobileNumber=" + mobileNumber + ", role=" + role + "]";
	}

	

	

}
