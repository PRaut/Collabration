package com.chatter.DAO;

import java.util.List;

import com.chatter.model.Job;

public interface JobDAO {
	public boolean addJob(Job job);
	public boolean deleteJob(Job job);
	public boolean updateJob(Job job);
	public List<Job> listJob();
	public boolean applyJob(Job job);
}
