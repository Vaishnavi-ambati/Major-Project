package com.vishnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vishnu.entity.CaseWorker;
import com.vishnu.entity.Plan;
import com.vishnu.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService serviceObj;
	
	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}
	
	@GetMapping("/createPlans")
	public String createPlanForm(Model m) {
		Plan planObj = new Plan();
		m.addAttribute("planAttr", planObj);
		return "createPlan";
	}
	
	@PostMapping("/createPlans")
	public String createPlan(@ModelAttribute("planAttr") Plan newPlanObj) {
		serviceObj.savePlan(newPlanObj);
		return "redirect:/viewPlans";
	}
	
	@GetMapping("/viewPlans")
	public String getViewPlans(Model m) {
		m.addAttribute("planAttr", serviceObj.getAllPlanss());
		return "viewPlans";
	}
	
	@GetMapping("/createAccount")
	public String createAccountForm(Model m) {
		
		CaseWorker caseWorkerObj = new CaseWorker();
		m.addAttribute("workerAttr", caseWorkerObj);
		return "createAcc";
	}
	
	@GetMapping("/viewAccounts")
	public String getViewAccounts(Model m, @RequestParam(name = "accountCreated", defaultValue = "false") boolean accountCreated) {
		m.addAttribute("workerAttr", serviceObj.getAllCaseWorkers());
		m.addAttribute("accountCreated", accountCreated);
		return "viewAccs";
	}
	
	@PostMapping("/createAccount")
	public String accountCreation(@ModelAttribute("workerAttr") CaseWorker newWorkerObj) {
		serviceObj.saveAccount(newWorkerObj);
		return "redirect:/viewAccounts";
		
	}
	
	@GetMapping("/updateAccount/{id}")
	public String updateAccountForm(@PathVariable Integer id, Model m) {
		CaseWorker caseWorkerObj = serviceObj.getCaseWorkerById(id);
		m.addAttribute("workerAttr", caseWorkerObj);
		return "updateAcc"; 
	}
	
	@PostMapping("/updateAccount/{id}")
	public String updateAccount(@PathVariable Integer id, @ModelAttribute("workerAttr") CaseWorker newWorkerObj, Model m) {
		
		CaseWorker caseWorkerObj = serviceObj.getCaseWorkerById(id);
		
		caseWorkerObj.setEmail(newWorkerObj.getEmail());
		caseWorkerObj.setFullName(newWorkerObj.getFullName());
		caseWorkerObj.setGender(newWorkerObj.getGender());
		caseWorkerObj.setMobile(newWorkerObj.getMobile());
		caseWorkerObj.setSsn(newWorkerObj.getSsn());
		
		serviceObj.saveAccount(caseWorkerObj);
		
		return "redirect:/viewAccounts";
	}
	
	@GetMapping("/updatePlan/{id}")
	public String updatePlanForm(@PathVariable Integer id, Model m) {
		Plan planObj = serviceObj.getPlanById(id);
		m.addAttribute("planAttr", planObj);
		return "updatePlan"; 
	}
	
	@PostMapping("/updatePlan/{id}")
	public String updatePlan(@PathVariable Integer id,@ModelAttribute("planAttr") Plan newPlanObj, Model m) {
		
		Plan planObj = serviceObj.getPlanById(id);

		planObj.setPlanName(newPlanObj.getPlanName());
		planObj.setPlanCategory(newPlanObj.getPlanCategory());
		planObj.setPlanStartDate(newPlanObj.getPlanStartDate());
		planObj.setPlanEndDate(newPlanObj.getPlanEndDate());
		
		serviceObj.savePlan(planObj);
		
		return "redirect:/viewPlans";
	}
	
	@GetMapping("/updateAccountStatus/{id}/{status}")
	public String accountStatusUpdate(@PathVariable Integer id, @PathVariable String status, Model m) {
		
		if(status.equals("Y")) {
			m.addAttribute("msg", "Activated");
		}
		else {
			m.addAttribute("msg", "De-Activated");
		}
		serviceObj.updateAccountStatus(id, status);
		
		return "forward:/viewAccounts";
	}
	
	@GetMapping("/updatePlanStatus/{id}/{status}")
	public String planStatusUpdate(@PathVariable Integer id, @PathVariable String status, Model m) {
		
		if(status.equals("Y")) {
			m.addAttribute("msg", "Activated");
		}
		else {
			m.addAttribute("msg", "De-Activated");
		}
		serviceObj.updatePlanStatus(id, status);
		
		return "forward:/viewPlans";
	}

}
