package com.test.reactapp.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.reactapp.beans.JobApplication;
import com.test.reactapp.dao.ApplyJobDAO;

@RestController
public class ApplyJobRestController {

	@Autowired
	private ApplyJobDAO applyJobDAO;
	
	@RequestMapping(value="/apply/job",method=RequestMethod.POST)
	public ResponseEntity<HashMap<String,Object>> applyJob(@RequestParam String name,@RequestParam String email,
			@RequestParam String mobile,@RequestParam Integer jobId,@RequestParam Boolean agreeTerms){
		HashMap<String,Object> response=new HashMap<String,Object>();
		JobApplication application=new JobApplication();
		application.setName(name);
		application.setEmail(email);
		application.setMobile(mobile);
		application.setJobId(jobId);
		application.setAgreeTerms(agreeTerms);
		Boolean result=applyJobDAO.save(application);
		response.put("success", result);
		return new ResponseEntity<HashMap<String,Object>>(response,HttpStatus.OK);
	}
	
}
