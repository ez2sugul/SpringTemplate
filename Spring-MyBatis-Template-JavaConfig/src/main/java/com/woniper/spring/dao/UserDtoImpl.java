package com.woniper.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniper.spring.dto.UserDto;

@Repository
public class UserDtoImpl implements UserDao {

	@Autowired SqlSession session;
	
	@Override
	public List<UserDto> getList() {
		return session.selectList("hello.getList");
	}

}
