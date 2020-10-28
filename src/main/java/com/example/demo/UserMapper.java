package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	@Insert("INSERT INTO UserProfile(company_id, user_name, user_email, user_phone, user_address) VALUES(#{user.companyId}, #{user.name}, #{user.email}, #{user.phone}, #{user.address})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(@Param("user") UserProfile user);
	
	@Results(id="UserProfileMap", value={
		@Result(property="companyId", column="company_id"),
		@Result(property="name", column="user_name"),
		@Result(property="email", column="user_email"),
		@Result(property="phone", column="user_phone"),
		@Result(property="address", column="user_address")
	})
	@Select("<script>SELECT * FROM UserProfile <if test='keyword != null'>WHERE user_name like CONCAT( '%', CONCAT( #{keyword}, '%' ))</if> <if test='orderBy != null'>ORDER BY ${orderBy}</if></script>")
	List<UserProfile> getByKeyword(@Param("keyword") String keyword, @Param("orderBy") String orderBy);
	
	@ResultMap("UserProfileMap")
	@Select("SELECT * FROM UserProfile")
	List<UserProfile> getAll();
	
	@ResultMap("UserProfileMap")
	@Select("SELECT * FROM UserProfile WHERE id=#{id}")
	UserProfile getById(int id);
	
	@ResultMap("UserProfileMap")
	@Select("SELECT * FROM UserProfile WHERE company_id=#{id}")
	List<UserProfile> getByCompanyId(@Param("id") int companyId);
}
