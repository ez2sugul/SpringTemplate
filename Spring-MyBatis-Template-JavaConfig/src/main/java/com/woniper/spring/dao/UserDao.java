package com.woniper.spring.dao;

import java.util.List;

import com.woniper.spring.dto.UserDto;

public interface UserDao {
	
	List<UserDto> getList();

}
