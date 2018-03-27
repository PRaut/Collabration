package com.chatter.DAO;

import java.util.List;

import com.chatter.model.ApplyJob;
import com.chatter.model.Job;

public interface JobDAO {
	public boolean addJob(Job job); 
	public boolean deleteJob(Job job); 
	public boolean updateJob(Job job); 
	public Job getJob(int jobId);     
	public List<Job> listJob();  
	/*public boolean applyJob(Job job); */

	// -----------------------
	
	public boolean applyJob(ApplyJob app);
	public List<ApplyJob> getAllApplicationJobDetails();
}
