package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.BusResv;
import com.example.demo.service.BusresvService;

import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
public class BusresvController {

	public int pageSIZE = 5;
	public int totalRecord = 0;
	public int totalPage = 1;

	@Autowired
	private BusresvService bs;
	
	//소현
	int a = 101;
	
	@GetMapping("/busresv/list/{pageNUM}")
	public String list(Model model, @PathVariable("pageNUM") int pageNUM) {
		System.out.println("pageNUM:"+pageNUM);
		totalRecord = bs.count(); //count는 기본적으로제공해줘
		
		totalPage =(int) Math.ceil((double)totalRecord/pageSIZE);
		int start = (pageNUM-1)*pageSIZE+1;
		int end = start+pageSIZE-1;
		
		System.out.println("start:"+start);
		System.out.println("end:"+end);
		
		model.addAttribute("list", bs.busresv_list_count(start, end)); 
		model.addAttribute("totalPage", totalPage);

		return "/busresv/list";
	}

	
	@GetMapping("/busresv/insert")
	public void insertForm(HttpSession session, Model model) {	
		//로그인사람의 정보를 가져오기위해
		//지수
		System.out.println("수정됨ㅇㅇㅇㅇ");
		Authentication authentication
		= SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String id = user.getUsername();
		model.addAttribute("id", id);
		System.out.println("insert폼작동");
	}
	
	@PostMapping("/busresv/insert")
	public String insertSubmit(BusResv b) {
		String view = "redirect:/busresv/list/1";
		bs.insert(b);
		return view;
	}

	@GetMapping("/busresv/delete/{resvno}")
	public String delete(@PathVariable("resvno") int resvno) {
		String view = "redirect:/busresv/list/1";
		bs.deleteBusresv(resvno);
		return view;
	}
	
	@GetMapping("/busresv/update/{resvno}")
	public String bus_update(@PathVariable int resvno, Model model) {
		model.addAttribute("busresv", bs.getBusresv(resvno));
		return "/busresv/update";
	}
	
	@PostMapping("/busresv/update")
	public String busresv_updateSubmit(BusResv b) {
		String view = "redirect:/busresv/list/1";
		bs.updateBusresv(b);
		return view;
	}
}
