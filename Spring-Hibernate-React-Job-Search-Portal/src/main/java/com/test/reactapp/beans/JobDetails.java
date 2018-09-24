package com.test.reactapp.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="jobDetails")
public class JobDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="companyId")
	private Integer companyId;
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="id")
	private CompanyDetails companyDetails;
	@Column(name="technology")
	private String technology;
	@Column(name="type")
	private String type;
	@Column(name="jobLocation")
	private String jobLocation;
	@Column(name="yoeLower")
	private Float yoeLower;
	@Column(name="yoeUpper")
	private Float yoeUpper;
	@Column(name="createdOn")
	private Date createdOn;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="skills",joinColumns=@JoinColumn(name="jobId"),inverseJoinColumns=@JoinColumn(name="id"))
	private List<Skills> skills;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public Float getYoeLower() {
		return yoeLower;
	}
	public void setYoeLower(Float yoeLower) {
		this.yoeLower = yoeLower;
	}
	public Float getYoeUpper() {
		return yoeUpper;
	}
	public void setYoeUpper(Float yoeUpper) {
		this.yoeUpper = yoeUpper;
	}
	public List<Skills> getSkills() {
		return skills;
	}
	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}
	public CompanyDetails getCompanyDetails() {
		return companyDetails;
	}
	public void setCompanydetails(CompanyDetails companyDetails) {
		this.companyDetails = companyDetails;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
}
