package com.vishnu.service;

import com.vishnu.entity.CitizenInfo;
import com.vishnu.entity.CitizenOutput;

public interface CitizenService {
	
	public CitizenOutput getCitizenByDetails(CitizenInfo citizenObj);

}
