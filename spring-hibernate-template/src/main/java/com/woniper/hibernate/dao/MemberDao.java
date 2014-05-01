package com.woniper.hibernate.dao;

import java.util.List;

import com.woniper.hibernate.domain.Member;
import com.woniper.hibernate.domain.MemberDto;

public interface MemberDao {

	void add(Member member);
	void update(Member member);
	Member get(int id);
	List<Member> list();
	List<Member> list(int page, int size);
	boolean delete(int id);
	void memberAdd(MemberDto dto);
}
