package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.example.demo.form.UserForm;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name") })
public class AppUser {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue
	private long userId;

	@Column(name = "USER_NAME", length = 100)
	private String userName;

	@Column(name = "ENCRYTED_PASSWORD", length = 100)
	private String encrytedPassword;

	@Column(name = "ENABLED")
	private boolean enabled;

	@Column(name = "ADDRESS", length = 100)
	private String address;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "PHONE", length = 15)
	private String phone;

	@Column(name = "RESET_TOKEN", length = 36)
	private String resetToken;

	public AppUser() {

	}

	public AppUser(long userId, String userName, String encrytedPassword, boolean enabled, String address, String email,
			String phone, String resetToken) {

		this.userId = userId;
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.enabled = enabled;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.resetToken = resetToken;
	}

	public AppUser(UserForm form) {
		this.userName = form.getName();
		this.email = form.getEmail();
		this.encrytedPassword = form.getPassword();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

}
