package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Bus;
import com.example.demo.entity.BusRoad;
import com.example.demo.entity.Bus_BusRoad;

import jakarta.transaction.Transactional;
@Repository
public interface BusRoadDAO extends JpaRepository<BusRoad, Integer> {
	
	@Query(value = "select * from busroad order by roadno", nativeQuery = true)
	public List<BusRoad> listBusRoad();
	
	@Query(value = "select nvl(max(roadno),0)+1 from busroad", nativeQuery = true)
	public int getNextRoadno();

	@Modifying
	@Query(value = "delete from busroad b where b.roadno=?1", nativeQuery = true)
	@Transactional
	public int deleteBusroad(int roadno);
	
	@Query(value =  "select * from (select rownum n,A.* from (select * from busroad order by busno)A) "
			+ "where n between ?1 and ?2 ",nativeQuery = true)
	public List<BusRoad> busroad_list_count(int start, int end);

	//도로번호로 버스번호만 뽑아오는것
	@Query(value = "select busno from busroad where roadno=?1",nativeQuery = true)
	public int getBusRoadByRoadno(int roadno);

}
