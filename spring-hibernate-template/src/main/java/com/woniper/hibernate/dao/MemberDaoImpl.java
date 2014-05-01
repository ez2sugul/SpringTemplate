package com.woniper.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.woniper.hibernate.domain.Member;
import com.woniper.hibernate.domain.MemberDto;

@Repository
@Transactional
public class MemberDaoImpl implements MemberDao {
	
	@Autowired SessionFactory sessionFactory;
	// sessionFactory.openSession() -> Hibernate에서 session관리를 할 경우
	// sessionFactory.getCurrentSession() -> Spring에서 Session관리를 할 경우(HibernateTransactionManager)
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	private Criteria getCriteria() {
		return getSession().createCriteria(Member.class);
	}

	@Override
	public void add(Member member) {
		getSession().save(member);
	}

	@Override
	public void update(Member member) {
		getSession().update(member);
	}

	// Criteria : HQL보다 객체지향적인 쿼리 작성 
	@Override
	public Member get(int id) {
		return (Member) getCriteria().add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Member> list() {
		return getSession().createQuery("from Member").list();
	}
	
	// paging 처리 
	@Override
	public List<Member> list(int page, int size) {
		return getCriteria().setFirstResult(size * (page - 1)).setMaxResults(size).list();
	}

	// HQL
	@Override
	public boolean delete(int id) {
		return getSession().createQuery("delete from Member where id = ?").setInteger(0, id).executeUpdate() > 0;
	}

	@Override
	public void memberAdd(MemberDto dto) {
		getSession().save(dto);
	}

}
