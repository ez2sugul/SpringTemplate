package com.woniper.hibernate.contoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniper.hibernate.domain.Member;
import com.woniper.hibernate.domain.MemberDto;
import com.woniper.hibernate.service.MemberService;

@Controller
public class HelloController {
	
	@Autowired private MemberService service;
	
	// insert **
	@ResponseBody
	@RequestMapping(value = "/c", method=RequestMethod.POST)
	public Member create(@Valid @ModelAttribute("member") Member member) {
		System.out.println(member.toString());
		service.add(member);
		return service.get(member.getId());
	}

	// select **
	@ResponseBody
	@RequestMapping(value = "/r", params = {"id"}, method=RequestMethod.GET)
	public Member read(@RequestParam int id) {
		return service.get(id);
	}
	
	// update
	@ResponseBody
	@RequestMapping(value = "/u", method=RequestMethod.PUT)
	public Member update(Member member) {
		System.out.println(member.toString());
//		service.update(member);
//		return service.get(member.getId());
		return null;
	}
	
	// delete **
	@RequestMapping(value = "/d/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		System.out.println(id);
		service.delete(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public List<Member> list() {
		return service.list();
	}
	
	@ResponseBody
	@RequestMapping(value = "/sign", method=RequestMethod.POST)
	public void memberSign(MemberDto dto) {
		System.out.println(dto.toString());
		service.memberAdd(dto);
	}
}
