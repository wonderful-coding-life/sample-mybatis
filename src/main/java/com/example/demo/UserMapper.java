package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	@Insert("INSERT INTO UserProfile(name, email, phone, address) VALUES(#{user.name}, #{user.email}, #{user.phone}, #{user.address})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(@Param("user") UserProfile user);
	
	@Select("<script>SELECT * FROM UserProfile <if test='keyword != null'>WHERE name like CONCAT( '%', CONCAT( #{keyword}, '%' ))</if> <if test='orderBy != null'>ORDER BY ${orderBy}</if></script>")
	List<UserProfile> select(@Param("keyword") String keyword, @Param("orderBy") String orderBy);
}
