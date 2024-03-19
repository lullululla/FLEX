package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "memberBusRoad")
public class Member_BusRoad {
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
	private int position;
	private int gender;
	private int point;
	private String joindate;
	private int roadno;
	private int busno;
	private String arrival;
	private String departure;
	private int price;
	private int arrtime;
	private int tottime;
}