package com.vishnu.entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CitizenInfo {

	private String fullName;
	private LocalDate dob;
	private String gender;
	private String ssn;

}
