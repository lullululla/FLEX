package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/")
	public String TestController() {
		System.out.println("hhhh");
		System.out.println("수정됨ㅇㅇㅇ");
		return "...";
	}
	
}
