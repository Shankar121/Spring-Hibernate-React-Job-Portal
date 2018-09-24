package com.test.reactapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.reactapp.beans.JobDetails;
import com.test.reactapp.dao.JobSearchDAO;

@RestController
public class JobRestController {
	
	@Autowired
	private JobSearchDAO jobSearchDAO;
	
	@RequestMapping(value="/allJobs",method=RequestMethod.POST)
	public ResponseEntity<HashMap<String,Object>> getHome(){
		HashMap<String,Object> response=new HashMap<String,Object>();
		List<String> allLocation=new ArrayList<String>();
		List<JobDetails> jobDetails=jobSearchDAO.fetchAllJobDetails();
		for (JobDetails job : jobDetails) {
			allLocation.add(job.getJobLocation());
		}
		JSONArray obj=new JSONArray(jobDetails);
		response.put("jobDetails", obj.toString());
		response.put("allLocation", allLocation);
		return new ResponseEntity<HashMap<String,Object>>(response,HttpStatus.OK);
	}
	@RequestMapping(value="/searchByKeyword",method=RequestMethod.POST)
	public ResponseEntity<HashMap<String,Object>> searchByKeyword(@RequestParam String searchText){
		HashMap<String,Object> response=new HashMap<String,Object>();
		List<JobDetails> jobDetails=jobSearchDAO.searchByKeyword(searchText);
		JSONArray obj=new JSONArray(jobDetails);
		response.put("jobDetails", obj.toString());
		return new ResponseEntity<HashMap<String,Object>>(response,HttpStatus.OK);
	}
	@RequestMapping(value="/searchByType",method=RequestMethod.POST)
	public ResponseEntity<HashMap<String,Object>> searchByType(@RequestParam String type){
		HashMap<String,Object> response=new HashMap<String,Object>();
		List<JobDetails> jobDetails=jobSearchDAO.searchByType(type);
		JSONArray obj=new JSONArray(jobDetails);
		response.put("jobDetails", obj.toString());
		return new ResponseEntity<HashMap<String,Object>>(response,HttpStatus.OK);
	}
	@RequestMapping(value="/searchByExp",method=RequestMethod.POST)
	public ResponseEntity<HashMap<String,Object>> searchByExp(@RequestParam Float yoeLower,@RequestParam Float yoeUpper){
		HashMap<String,Object> response=new HashMap<String,Object>();
		List<JobDetails> jobDetails=jobSearchDAO.searchByExp(yoeLower,yoeUpper);
		JSONArray obj=new JSONArray(jobDetails);
		response.put("jobDetails", obj.toString());
		return new ResponseEntity<HashMap<String,Object>>(response,HttpStatus.OK);
	}
	@RequestMapping(value="/searchByLoc",method=RequestMethod.POST)
	public ResponseEntity<HashMap<String,Object>> searchByLoc(@RequestParam String location){
		HashMap<String,Object> response=new HashMap<String,Object>();
		List<JobDetails> jobDetails=jobSearchDAO.searchByLoc(location);
		JSONArray obj=new JSONArray(jobDetails);
		response.put("jobDetails", obj.toString());
		return new ResponseEntity<HashMap<String,Object>>(response,HttpStatus.OK);
	}

}
