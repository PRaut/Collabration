package com.chatter.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Job implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy= GenerationType.SEQUENCE, generator="job_sequence")
	@SequenceGenerator(name="job_sequence", sequenceName="job_seq", initialValue=1, allocationSize=1)
	@Column(nullable= false)
	private int jobId;
	private String jobTitle;
	private String jobDescription;
	private long salary;
	//private String applyStatus;
	private int noOfOpenings;
	private String jobDesignation;
	private String jobLocation;
	private String company;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern= "dd-MM-yyyy")
	private Date lastDateToApply;
	
	public int getJobId() {
		return jobId;
	}
	
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	/*public String getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}*/
	
	public int getNoOfOpenings() {
		return noOfOpenings;
	}

	public void setNoOfOpenings(int noOfOpenings) {
		this.noOfOpenings = noOfOpenings;
	}

	public String getJobDesignation() {
		return jobDesignation;
	}

	public void setJobDesignation(String jobDesignation) {
		this.jobDesignation = jobDesignation;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getLastDateToApply() {
		return lastDateToApply;
	}

	public void setLastDateToApply(Date lastDateToApply) {
		this.lastDateToApply = lastDateToApply;
	}
	
	

}
