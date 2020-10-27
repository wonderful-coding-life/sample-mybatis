package com.example.demo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyProfile {
	private int id;
	private String name;
	private String address;
	private List<UserProfile> employees;
}
