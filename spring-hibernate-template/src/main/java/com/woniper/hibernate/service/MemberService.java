package com.woniper.hibernate.service;

import java.util.List;

import com.woniper.hibernate.domain.Member;
import com.woniper.hibernate.domain.MemberDto;

public interface MemberService {

	void add(Member member);
	void update(Member member);
	Member get(int id);
	List<Member> list();
	List<Member> list(int page, int size);
	void delete(int id);
	void memberAdd(MemberDto dto);

}
