package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "busroad")
public class BusRoad {
	
	@Id
	private int roadno;
	private int busno;
	private String id;
	private String arrival;
	private String departure;
	private int price;
	private int arrtime;
	private int tottime;
}
