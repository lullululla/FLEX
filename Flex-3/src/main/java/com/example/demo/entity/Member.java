package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class Member {	
	@Id
	private String id;
	private String passwd;
	private String name;
	private String jumin1;
	private String jumin2;
	private String email;
	private String hp1;
	private String hp2;
	private String hp3;
	private String role;	
	private int gender;
	private int point;
	private String joindate;
}