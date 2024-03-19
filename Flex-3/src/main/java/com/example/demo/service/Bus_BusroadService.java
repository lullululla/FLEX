package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BusDAO;
import com.example.demo.dao.BusRoadDAO;
import com.example.demo.dao.Bus_BusRoadDAO;
import com.example.demo.entity.Bus;
import com.example.demo.entity.BusRoad;
import com.example.demo.entity.Bus_BusRoad;

import lombok.Setter;

@Service
@Setter
public class Bus_BusroadService {
	@Autowired
	private Bus_BusRoadDAO dao;

	public List<Bus_BusRoad> listResv(int arrival, int departure, String grade){
		return dao.listResv(arrival,departure,grade);
	}
	public int listResv_count(int arrival, int departure, String grade, int start, int end){
		return dao.listResv_count(arrival,departure,grade,start,end);
	}
	public int listResv_reverse_count(int departure, int arrival, String grade, int start, int end) {
		return dao.listResv_reverse_count(departure, arrival, grade, start, end);
	}
	
	public List<Bus_BusRoad> listResv_reverse(int departure, int arrival, String grade){
		return dao.listResv_reverse(departure, arrival, grade);
	}
	
	public List<Bus_BusRoad> listResv_all(int arrival, int departure){
		return dao.listResv_all(arrival, departure);
	}
	public int listResv_all_count(int arrival, int departure, int start, int end){
		return dao.listResv_all_count(arrival, departure, start, end);
	}
	public List<Bus_BusRoad> listResv_all_reverse(int departure, int arrival){
		return dao.listResv_all_reverse(departure, arrival);
	}
	public List<Bus_BusRoad> listResv_all_reverse_count(int departure, int arrival, int start, int end){
		return dao.listResv_all_reverse_count(departure, arrival, start, end);
	}
	public List<Bus_BusRoad> resv_user_seat_select(int roadno){
		return dao.resv_user_seat_select(roadno);
	}
	public int resverse_count(int departure, int arrival, String grade) { 
		return dao.resverse_count(departure, arrival, grade);
	}
	public int resverse_all_count(int departure, int arrival) { 
		return dao.resverse_all_count(departure, arrival);
	}
	public List<Bus_BusRoad> bus_no_list_null(){
		return dao.bus_no_list_null();
	}
	public int bus_no_list_null_count() { 
		return dao.bus_no_list_null_count();
	}
	public Bus_BusRoad bus_no_null_rownum() {
		return dao.bus_no_null_rownum();
	}
	public void insert(Bus_BusRoad b) {
		dao.save(b);
	}
	public int delete(int busno){
		return dao.deleteBus_BusRoad(busno);
	}
	public Bus_BusRoad getBusroad(int busno) {
		return dao.findById(busno).get();
	}
	public void update(Bus_BusRoad b){
		dao.save(b);
	}
	public int count() {
		return (int)dao.count();
	}
}
