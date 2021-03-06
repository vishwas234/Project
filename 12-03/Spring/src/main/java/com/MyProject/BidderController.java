package com.MyProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.BidderDao;
import com.dao.FarmerDao;
import com.dto.Bidder;
import com.dto.Farmer;

@RestController
public class BidderController {
	
	@Autowired
	BidderDao bidderDao;
	

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/registerBidder")
	public Bidder registerBidder(@RequestBody Bidder bidder) throws Exception {
		String tempLoginId = bidder.getLoginId();
		if (tempLoginId != "null" && !"".equals(tempLoginId) ) {
			Bidder bidderObj = bidderDao.fetchBidderByLoginId(tempLoginId);
			if(bidderObj != null) {
				throw new Exception("User with" +tempLoginId +"is already Exist");
			}
		}
		Bidder bidderObj = null;
		bidderObj = bidderDao.registerBidder(bidder);
		System.out.println("Welcome");
		return bidderObj;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/loginBidder")
	public Bidder loginBidder(@RequestBody Bidder bidder) throws Exception {
		String tempLoginId = bidder.getLoginId();
		String tempPassword = bidder.getPassword();
		Bidder bidderObj =null;
		if(tempLoginId != null && tempPassword!= null) {
			bidderObj = bidderDao.fetchBidderByLoginIdAndPassword(tempLoginId, tempPassword);
		}
		if(bidderObj == null) {
			throw new Exception ("Bad Credentials..");
		}
		return bidderObj;

	
	    }
	
	
}