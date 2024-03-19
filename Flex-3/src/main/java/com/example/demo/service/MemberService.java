package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.entity.Member;

import lombok.Setter;

@Service
@Setter
public class MemberService implements UserDetailsService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public MemberService() {
		System.out.println("MemberService 생성됨");
	}
	
	public void insert(Member m ) {
		m.setPwd( passwordEncoder.encode(m.getPwd()) );
		memberDAO.save(m);
	}
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("loadUserByUsername 동작함!");
		System.out.println("username:"+username);
		
		Optional<Member> obj = memberDAO.findById(username);
		UserDetails user = null;
		if(obj.isPresent()) {
			Member m = obj.get();
			user = User.builder().username(username).password(m.getPwd()).roles(m.getRole()).build();
		}else {
			throw new UsernameNotFoundException(username);
		}
		
		return user;
	}

}












