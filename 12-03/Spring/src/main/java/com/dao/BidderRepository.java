package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.Bidder;
import com.dto.Farmer;
@Repository
public interface BidderRepository extends JpaRepository<Bidder,Integer>{
	
	public Bidder findByLoginId(String loginId);
	public Bidder findByLoginIdAndPassword(String loginId ,String password);


}
