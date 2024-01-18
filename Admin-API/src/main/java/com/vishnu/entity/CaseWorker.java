package com.vishnu.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CaseWorker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer workerId;
	private String fullName;
	private String email;
	private String mobile;
	private String gender;
	private LocalDate dob;
	private String ssn;
	private String workerActiveSwitch="Y";
	@CreationTimestamp
	@Column(updatable=false)
	private LocalDate createdDate;
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updatedDate;

}
