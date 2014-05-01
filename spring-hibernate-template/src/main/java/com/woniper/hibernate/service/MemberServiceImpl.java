package com.woniper.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniper.hibernate.dao.MemberDao;
import com.woniper.hibernate.domain.Member;
import com.woniper.hibernate.domain.MemberDto;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired private MemberDao dao;
	
	@Override
	public void add(Member member) {
		dao.add(member);
	}

	@Override
	public void update(Member member) {
		dao.update(member);
	}

	@Override
	public Member get(int id) {
		return dao.get(id);
	}

	@Override
	public List<Member> list() {
		return dao.list();
	}

	@Override
	public List<Member> list(int page, int size) {
		return dao.list(page, size);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}
	@Override
	public void memberAdd(MemberDto dto) {
		dao.memberAdd(dto);
	}

}
