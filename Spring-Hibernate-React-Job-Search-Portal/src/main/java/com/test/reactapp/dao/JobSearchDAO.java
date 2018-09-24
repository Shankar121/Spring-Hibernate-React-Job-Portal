package com.test.reactapp.dao;

import java.util.List;

import com.test.reactapp.beans.JobDetails;

public interface JobSearchDAO {
	public List<JobDetails> fetchAllJobDetails();

	public List<JobDetails> searchByKeyword(String searchText);

	public List<JobDetails> searchByType(String type);

	public List<JobDetails> searchByExp(Float yoeLower, Float yoeUpper);

	public List<JobDetails> searchByLoc(String location);
}
