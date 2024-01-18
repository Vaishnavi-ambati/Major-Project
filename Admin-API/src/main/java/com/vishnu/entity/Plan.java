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
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer planId;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private String planName;
	private String planCategory;
	private String planActiveSwitch="Y";
	@CreationTimestamp
	@Column(updatable=false)
	private LocalDate createdDate;
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updatedDate;
	

}
