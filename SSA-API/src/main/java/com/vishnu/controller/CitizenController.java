package com.vishnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.entity.CitizenInfo;
import com.vishnu.entity.CitizenOutput;
import com.vishnu.service.CitizenService;

@RestController
public class CitizenController {
	
	@Autowired
	private CitizenService serviceObj;
	
	@PostMapping(value="/citizensInfo",consumes = {"application/xml", "application/json"})
	public CitizenOutput getCitizenData(@RequestBody CitizenInfo citizenObj) {

		return serviceObj.getCitizenByDetails(citizenObj);
	}
	
	

}
