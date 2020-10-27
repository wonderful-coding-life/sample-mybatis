package com.example.demo;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Many;

@Mapper
public interface CompanyMapper {
	
	@Insert("INSERT INTO CompanyProfile(company_name, company_address) VALUES(#{company.name}, #{company.address})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(@Param("company") CompanyProfile company);
	
@Select("SELECT * FROM CompanyProfile")
@Results({
	@Result(property="id", column="id"),
	@Result(property="name", column="company_name"),
	@Result(property="address", column="company_address"),
	@Result(property="employees", column="id", many=@Many(select="com.example.demo.UserMapper.getByCompanyId"))
})
List<CompanyProfile> getAll();
}