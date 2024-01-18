package com.vishnu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnu.entity.CaseWorker;
import com.vishnu.entity.Plan;
import com.vishnu.repository.AdminPlansRepository;
import com.vishnu.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository repoObj;
	
	@Autowired
	private AdminPlansRepository plansRepoObj;

	@Override
	public String saveAccount(CaseWorker caseWorkerObj) {
		
		try {
			
			repoObj.save(caseWorkerObj);
			
			if(caseWorkerObj.getWorkerId() == null) {
				return "Case Worker created in Service Layer";
			}
			
			else {
				return "Case Worker updated in Service Layer";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String savePlan(Plan planObj) {
		try {
			plansRepoObj.save(planObj);
			
			if(planObj.getPlanId() == null) {
				planObj.setPlanActiveSwitch("Y");
				return "Case Worker created in Service Layer";
			}
			
			else {
				return "Case Worker updated in Service Layer";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<CaseWorker> getAllCaseWorkers() {
		
		return repoObj.findAll();
	}

	@Override
	public List<Plan> getAllPlanss() {
		return plansRepoObj.findAll();
		
	}

	@Override
	public boolean updateAccountStatus(Integer workerId, String status) {
		
		try {
			repoObj.updateWorkerAccStatus(workerId, status);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updatePlanStatus(Integer planId, String status) {
		try {
			plansRepoObj.updatePlanStatus(planId, status);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public CaseWorker getCaseWorkerById(Integer caseWorkerId) {
		
		return repoObj.findById(caseWorkerId).get();
	}

	@Override
	public Plan getPlanById(Integer planId) {

		return plansRepoObj.findById(planId).get();
	}
	
	
	
	

}
