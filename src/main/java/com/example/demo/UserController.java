package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserMapper userMapper;
	private UserService userService;
	
	@Autowired
	public UserController(UserMapper userMapper, UserService userService) {
		super();
		this.userMapper = userMapper;
		this.userService = userService;
	}

	@PostMapping("")
	public UserProfile insertUserProfile(@RequestBody UserProfile user) throws Exception {
		//userMapper.insert(user);
		userService.addUser(user);
		return user;
	}
	
	@GetMapping("")
	public List<UserProfile> getUserProfile(@RequestParam(value="keyword", required=false) String keyword, @RequestParam(value="orderBy", required=false) String orderBy) {
		return userMapper.getByKeyword(keyword, orderBy);
	}
}

