package com.stock.management.system.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stock.management.system.model.UserDtls;
import com.stock.management.system.service.EmailService;
import com.stock.management.system.service.UserService;

@Controller
public class ForgotPasswordController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@PostMapping("/resetPassword")
	public String resetPassword(@RequestParam("email") String email, HttpSession session) {
		UserDtls user = userService.getUserByEmail(email);

		if (user == null) {
			// User with the provided email does not exist
			session.setAttribute("error", "User not found");
			return "redirect:/forgotPassword";
		}

		String resetToken = generateResetToken();

		user.setResetToken(resetToken);
		userService.createUser(user);

	
		String resetLink = "http://your-app.com/resetPassword?token=" + resetToken;
		String emailContent = "Dear " + user.getName() + ",\n\n"
				+ "Please click on the following link to reset your password:\n" + resetLink + "\n\n"
				+ "If you did not request a password reset, please ignore this email.\n\n" + "Best regards,\n"
				+ "Your App Team";

		emailService.sendEmail(user.getEmail(), "Password Reset Instructions", emailContent);

		return "redirect:/passwordResetConfirmation";
	}

	private String generateResetToken() {
		return null;
	}

}
