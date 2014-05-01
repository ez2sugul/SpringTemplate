package com.woniper.spring.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniper.spring.dao.SpringDao;
import com.woniper.spring.dao.UserDao;
import com.woniper.spring.dto.MemberDto;
import com.woniper.spring.dto.UserDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired private SpringDao dao;
	@Autowired private UserDao uDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		String text = dao.helloSpring();
		model.addAttribute("text", text);
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public List<UserDto> list() {
		return uDao.getList();
	}
	
	@RequestMapping(value = "/put/{userdto}", method=RequestMethod.PUT)
	public void put(@PathVariable("userdto") UserDto dto) {
		System.out.println(dto.toString());
	}
	
	@RequestMapping(value = "/sign", method=RequestMethod.POST)
	public @ResponseBody boolean memberSign(MemberDto dto) {
		return dao.memberSign(dto);
	}
	
	
}
