package com.chatter.JobTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.JobDAO;
import com.chatter.model.Job;

public class TestInsertJob {
	@Autowired
	public static SessionFactory sessionFactory;
	
	@Autowired 
	public static JobDAO jobDAO;	
	
	public static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.chatter");
		context.refresh();
		
		jobDAO = (JobDAO)context.getBean("jobDAO");
	}
	
	@Test
	public void testInsertJob(){
		Job job = new Job();
		job.setJobTitle("Test Job 1");
		job.setJobDescription("This is Test Job 1");
		job.setSalary(10000);
		//job.setApplyStatus("NA");
		job.setNoOfOpenings(2);
		job.setJobLocation("Mum");
		job.setCompany("PR SOLns");
		job.setLastDateToApply(new Date());
		
		/*Job job = new Job();
		job.setJobTitle("Test Job 2");
		job.setJobDescription("This is Test Job 2");
		job.setSalary(20000);
		job.setApplyStatus("NA");*/
		
		assertEquals("Job Insertion Failed", true, jobDAO.addJob(job));
	}
}
