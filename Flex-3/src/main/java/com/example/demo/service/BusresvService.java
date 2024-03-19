package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.BusResvDAO;
import com.example.demo.entity.BusResv;
import lombok.Setter;

@Service
@Setter
public class BusresvService {
	@Autowired
	private BusResvDAO dao;

	public List<BusResv> listBusresv(){
		return dao.findAllByOrderByResvno();
	}
	public List<BusResv> busresv_list_count(int start,int end){
		return dao.busresv_list_count(start,end);
	}
	public void insert(BusResv b) {
		b.setResvno(dao.getNextResvno());
		dao.save(b);
	}
	public int deleteBusresv(int resvno){
		return dao.deleteBusresv(resvno);
	}
	public BusResv getBusresv(int resvno) {
		return dao.findById(resvno).get();
	}
	public void updateBusresv(BusResv b){
		dao.save(b);
	}
	public int count() {
		return (int)dao.count();
	}
}
