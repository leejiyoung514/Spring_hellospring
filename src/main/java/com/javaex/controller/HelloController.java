package com.javaex.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaex.vo.UserVo;

@Controller

public class HelloController {  //주소를 정의하는 곳 
	
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("/hellospring/hello");
		return "/WEB-INF/views/index.jsp";
	}

	@RequestMapping("/main")
	public String main() {
		System.out.println("/hellospring/main");
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)		
	//디스페처서블릿에게 파라미터를 요청해함
	public String add(@RequestParam("age")int age,
    @RequestParam("name") String name) {	
    System.out.println(age);
    System.out.println(name);
		return "";
	}
	
	@RequestMapping(value="/add2", method=RequestMethod.GET)		
	public String add2(@ModelAttribute UserVo userVo, @RequestParam("nick") String nick) {	
		  System.out.println(userVo.toString());
		  System.out.println(nick);
		return "";
	}
	
	@RequestMapping(value="/read/{no}", method=RequestMethod.GET)
	public String read(@PathVariable("no") int no) {
		System.out.println(no+"번 글 가져오기");	
		return "";
	}
	
	@RequestMapping(value="/add3", method=RequestMethod.GET)
	public String add3(HttpServletRequest request, HttpServletResponse response) { //객체의 주소를 줘서 다 가져올 수 있음
		String name=request.getParameter("name");
		System.out.println(name);
		return "";
	}
	
	@RequestMapping(value="/userlist",  method=RequestMethod.GET)
	public String list(Model model) {
		List<UserVo> userList=new ArrayList<UserVo>();
		UserVo user01=new UserVo(11,"지영");
		UserVo user02=new UserVo(22,"지용");
		UserVo user03=new UserVo(33,"안녕");
		userList.add(user01);
		userList.add(user02);
		userList.add(user03);
		System.out.println(userList.toString());
		
		model.addAttribute("userList", userList);
		
		return "/WEB-INF/views/index.jsp";

		
	}
	
	@RequestMapping(value="/userlist",  method=RequestMethod.GET)
	public String list(Model model, HttpServletRequest request, HttpSession session) {
		session.setAttribute("authUser", authUser);
		
		List<UserVo> userList=new ArrayList<UserVo>();
		UserVo user01=new UserVo(11,"지영");
		UserVo user02=new UserVo(22,"지용");
		UserVo user03=new UserVo(33,"안녕");
		userList.add(user01);
		userList.add(user02);
		userList.add(user03);
		System.out.println(userList.toString());
		
		model.addAttribute("userList", userList);
		
		return "/WEB-INF/views/index.jsp";

		
	}
	
}
