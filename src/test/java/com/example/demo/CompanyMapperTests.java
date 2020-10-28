package com.example.demo;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CompanyMapperTests {
	
	@Autowired
	private CompanyMapper companyMapper;

	@Test
	public void testInsert() {
		CompanyProfile company = CompanyProfile.builder().name("태평양").address("서울시 종로구 태평양").build();
		companyMapper.insert(company);
		Assertions.assertThat(company.getId()).isGreaterThan(0);
		
		List<CompanyProfile> companies = companyMapper.getAll();
		Assertions.assertThat(companies).isNotNull();
		
		CompanyProfile companyInserted = companyMapper.getById(company.getId());
		Assertions.assertThat(companyInserted).isNotNull();
		Assertions.assertThat(companyInserted.getName()).isEqualTo(company.getName());
		Assertions.assertThat(companyInserted.getAddress()).isEqualTo(company.getAddress());
	}
}
