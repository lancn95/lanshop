package com.example.demo.utils;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.UserForm;

public class PasswordIsValid {
	public static boolean IsValid(Model model, UserForm form, RedirectAttributes redirect) {
		if (!(form.getPassword().equals(form.getConfirmPassword()))) {
			model.addAttribute("message", "Mật khẩu phải giống với nhập lại mật khẩu");
			
			return false;
		}
		return true;

	}
}
