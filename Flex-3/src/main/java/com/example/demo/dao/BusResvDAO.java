package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Bus;
import com.example.demo.entity.BusResv;
import com.example.demo.entity.BusStation;

import jakarta.transaction.Transactional;
@Repository
public interface BusResvDAO extends JpaRepository<BusResv, Integer> {
	
	@Query(value = "select * from Busresv order by resvno", nativeQuery = true)
	public List<BusResv> findAllByOrderByResvno();
	
	@Query(value = "select nvl(max(resvno),0)+1 from busresv", nativeQuery = true)
	public int getNextResvno();

	@Modifying
	@Query(value = "delete from busresv b where b.resvno=?1", nativeQuery = true)
	@Transactional
	public int deleteBusresv(int resvno);
	
	@Query(value = "select * from (select rownum rn,A.* from (select * from busresv order by resvno)A) where rn between ?1 and ?2",nativeQuery = true)
	public List<BusResv> busresv_list_count(int start, int end);

}
