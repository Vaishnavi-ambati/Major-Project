package com.vishnu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vishnu.entity.CaseWorker;
import com.vishnu.entity.Plan;


public interface AdminService {
	
	public String saveAccount(CaseWorker caseWorkerObj);
	
	public String savePlan(Plan planObj);
	
	public List<CaseWorker> getAllCaseWorkers();
	
	public List<Plan> getAllPlanss();
	
	public boolean updateAccountStatus(Integer workerId, String status);
	
	public boolean updatePlanStatus(Integer planId, String status);
	
	public CaseWorker getCaseWorkerById(Integer caseWorkerId);
	
	public Plan getPlanById(Integer planId);
}
