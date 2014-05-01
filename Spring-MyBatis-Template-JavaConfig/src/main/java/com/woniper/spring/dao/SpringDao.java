package com.woniper.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniper.spring.dto.MemberDto;

@Repository
public class SpringDao {

	@Autowired private SqlSession mapper;
	
	public String helloSpring() {
		return mapper.selectOne("hello.Spring");
	}
	
	public boolean memberSign(MemberDto dto) {
		return mapper.insert("hello.memberSign", dto) > 0;
	}
}
