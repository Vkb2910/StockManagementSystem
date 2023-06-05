package com.stock.management.system.service;

import com.stock.management.system.model.UserDtls;

public interface UserService {

	UserDtls createUser(UserDtls user);

	boolean checkEmail(String email);

	UserDtls getCurrentUser();

	static UserDtls getUserByUsername(String username) {
		
		return null;
	}

	UserDtls getUserByEmail(String email);

	UserDtls getUser(Long id);

	void deleteUser(Long id);

	UserDtls updateUser(Long id, UserDtls user);
}
