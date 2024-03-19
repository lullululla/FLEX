package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "busbusroad")
public class Bus_BusRoad {
	@Id
	private int busno;
	private String grade; 
	private int seat;
	private int roadno;
	private String id;
	private String arrival;
	private String departure;
	private int price;
	private int arrtime;
	private int tottime;
	
}