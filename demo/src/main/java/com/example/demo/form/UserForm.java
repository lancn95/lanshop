package com.example.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserForm {
	@NotEmpty(message = "Tên không được để trống")
	private String name;

	@NotEmpty(message = "Email không được để trống")
	@Email
	private String email;

	@NotEmpty(message = "Mật khẩu không được để trống")
	private String password;

	@NotEmpty(message = "Nhập lại mật khẩu không được để trống")
	private String confirmPassword;

	public UserForm() {
	}

	public UserForm(String name, String email, String password, String encryptedPassword) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = encryptedPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
