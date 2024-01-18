package com.vishnu.service;

import org.springframework.stereotype.Service;

import com.vishnu.entity.CitizenInfo;
import com.vishnu.entity.CitizenOutput;

@Service
public class CitizenServiceImpl implements CitizenService{

	@Override
	public CitizenOutput getCitizenByDetails(CitizenInfo citizenObj) {
		
		CitizenOutput newcitizenObj = new CitizenOutput();
		
		newcitizenObj.setFullName(citizenObj.getFullName());
		newcitizenObj.setDob(citizenObj.getDob());
		newcitizenObj.setGender(citizenObj.getGender());
		newcitizenObj.setSsn(citizenObj.getSsn());
				
		try {
			switch (citizenObj.getSsn().charAt(0)) {
			  case '1':
				newcitizenObj.setStateName("New Jersey");

			    break;
			  case '2':
				newcitizenObj.setStateName("Ohio");

			    break;
			  case '3':
				 newcitizenObj.setStateName("Texas");

			    break;
			  case '4':
				newcitizenObj.setStateName("California");

			    break;
			  case '5':
				newcitizenObj.setStateName("Rhode Island");

			    break;
			  case '6':
				newcitizenObj.setStateName("Kentucky");

			    break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return newcitizenObj;
	}

}
