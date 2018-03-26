package com.chatter.JobTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.JobDAO;
import com.chatter.config.DBConfig;
import com.chatter.model.ApplyJob;

public class TestGetAllJobApplications {
	private static DBConfig config;
	@Autowired
	private static JobDAO jobDAO;

	@BeforeClass
	public static void setUp() {
		config = new DBConfig();
		// blogDAO = new
		// BlogDAOImpl(config.getSessionFactory(config.getDataSource()));
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.chatter");
		context.refresh();

		jobDAO = (JobDAO) context.getBean("jobDAO");
	}

	@Test
	public void testGetAllJobdetails() {
		ApplyJob app = new ApplyJob();

		List<ApplyJob> listApplyJobs = jobDAO.getAllApplicationJobDetails();

		assertTrue("List of Applyjob data display", listApplyJobs.size() > 0);

		for (ApplyJob j1 : listApplyJobs) {
			System.out.println(j1.getApplicationId() + "::");
			System.out.println(j1.getJobId() + "::");
			System.out.println(j1.getLoginName() + "::");
			System.out.println(j1.getApplyDate() + "::");
		}
	}
}
