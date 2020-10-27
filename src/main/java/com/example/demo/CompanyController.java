package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CompanyController {

	private CompanyMapper companyMapper;
	
	public CompanyController(CompanyMapper companyMapper) {
		super();
		this.companyMapper = companyMapper;
	}

	@PostMapping("/company")
	public CompanyProfile post(@RequestBody CompanyProfile company) {
		companyMapper.insert(company);
		return company;
	}
	
	@GetMapping("/company")
	public List<CompanyProfile> get() {
		return companyMapper.getAll();
	}
}
