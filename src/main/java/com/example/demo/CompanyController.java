package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/company")
public class CompanyController {

	private CompanyMapper companyMapper;
	private UserMapper userMapper;
	
	@Autowired
	public CompanyController(CompanyMapper companyMapper, UserMapper userMapper) {
		super();
		this.companyMapper = companyMapper;
		this.userMapper = userMapper;
	}

	@PostMapping("")
	public CompanyProfile post(@RequestBody CompanyProfile company) {
		companyMapper.insert(company);
		return company;
	}
	
	@GetMapping("")
	public List<CompanyProfile> get() {
		return companyMapper.getAll();
	}
	
	@GetMapping("/{id}")
	public CompanyProfile get(@PathVariable("id") int id) {
		return companyMapper.getById(id);
	}
	
	@GetMapping("/{id}/employee")
	public List<UserProfile> getEmployee(@PathVariable("id") int id) {
		return userMapper.getByCompanyId(id);
	}
}
