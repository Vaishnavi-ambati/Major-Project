package com.vishnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vishnu.entity.Plan;

import jakarta.transaction.Transactional;

public interface AdminPlansRepository extends JpaRepository<Plan, Integer>{
	
	@Modifying
	@Transactional
	@Query("update Plan set planActiveSwitch=:#{#status} where planId=:#{#exPlanId}")
	public void updatePlanStatus(Integer exPlanId, String status);

}
