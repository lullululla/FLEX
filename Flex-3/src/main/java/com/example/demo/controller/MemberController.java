package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

import lombok.Setter;

@Controller
@Setter
public class MemberController {
	@Autowired
	private MemberService ms;

	@GetMapping("/member/login")
	public void loginForm() {		
	}
	
	@GetMapping("/member/join")
	public void joinForm() {		
	}
	
	@PostMapping("/member/join")
	@ResponseBody
	public String joinSubmit(Member m) {
		ms.insert(m);
		return "OK";
	}
}

