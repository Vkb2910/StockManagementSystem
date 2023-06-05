package com.stock.management.system.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.management.system.model.UserDtls;
import com.stock.management.system.repository.UserRepository;
import com.stock.management.system.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserService userService;

	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);

		m.addAttribute("user", user);

	}

	@GetMapping("/")
	public String home() {
		return "user/home";
	}

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/profile")
	public String showUserProfile(Model model) {
		UserDtls user = userService.getCurrentUser(); 
		model.addAttribute("user", user);
		return "profile";
	}
	@PostMapping
    public UserDtls createUser(@RequestBody UserDtls user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserDtls getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public UserDtls updateUser(@PathVariable Long id, @RequestBody UserDtls user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}