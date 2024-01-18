package com.vishnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vishnu.entity.CaseWorker;

import jakarta.transaction.Transactional;

@Repository
public interface AdminRepository extends JpaRepository<CaseWorker, Integer>{
	
	@Modifying
	@Transactional
	@Query("update CaseWorker set workerActiveSwitch=:#{#status} where workerId=:#{#exWokerId}")
	public void updateWorkerAccStatus(Integer exWokerId, String status);	

}
