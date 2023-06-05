package com.stock.management.system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stock.management.system.model.UserDtls;
import com.stock.management.system.repository.UserRepository;
import com.stock.management.system.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		UserDtls user = userRepo.findByEmail(email);

		if (user != null) {
			return new CustomUserDetails(user);
		}

		throw new UsernameNotFoundException("user not available");
	}

	public UserDtls getCurrentUser() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.isAuthenticated()) {
			
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			UserDtls user = null;
			try {
				user = UserService.getUserByUsername(userDetails.getUsername());
			} catch (Exception e) {
			
				e.printStackTrace();
			}

			return user;
		}

		return null; 
	}

}