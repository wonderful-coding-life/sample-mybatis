package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService  {

	private UserMapper userMapper;
	
	public UserService(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Transactional
	public UserProfile addUser(UserProfile user) throws Exception {
		userMapper.insert(user);
		addUserToLegacy(user);
		return user;
	}
	
	private void addUserToLegacy(UserProfile userProfile) throws Exception {
		//throw new RuntimeException("ERP Exception");
	}
}
