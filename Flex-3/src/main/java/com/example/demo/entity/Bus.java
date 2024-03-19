package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "bus")
public class Bus {
	
	@Id
	private int busno;
	private String grade; 
	private int seat;
}
