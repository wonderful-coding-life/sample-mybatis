package com.example.demo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserProfile {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
}
