package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.AppUser;
import com.example.demo.form.UserForm;
import com.example.demo.service.UserService;
import com.example.demo.utils.PasswordIsValid;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public String signUp(Model model) {
		UserForm userForm = new UserForm();

		model.addAttribute("userForm", userForm);
		return "customer/sign-up";
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public String signUpSuccess(@ModelAttribute UserForm userForm, RedirectAttributes redirect, Model model,
			BindingResult result) {

		if (result.hasErrors()) {
			return "customer/sign-up";
		}

		if (userForm == null) {
			return "customer/sign-up";
		}
		System.out.println("pass: " + userForm.getPassword());
		System.out.println("ConfirmPass: " + userForm.getConfirmPassword());
		if (userForm != null) {
			// check pass == confirmpassword
			if (PasswordIsValid.IsValid(model, userForm, redirect) == false) {
				return "customer/sign-up";
			} else {
				AppUser user = new AppUser(userForm);
				user.setEnabled(true);
				userService.save(user);

				redirect.addFlashAttribute("message", "Bạn đã đăng ký thành công");
			}
		}
		return "redirect:/dang-nhap";
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public String signIn() {
		return "customer/sign-in";
	}
}
