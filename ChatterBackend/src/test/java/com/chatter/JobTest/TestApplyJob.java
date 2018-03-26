package com.chatter.JobTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.JobDAO;
import com.chatter.config.DBConfig;
import com.chatter.model.ApplyJob;

public class TestApplyJob {
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
	public void testApplyJob() {
		ApplyJob app = new ApplyJob();

		System.out.println("enter in applyjob test");
		app.setApplyDate(new java.util.Date());
		System.out.println("enter in applyjob test date");
		app.setJobId(1);
		System.out.println("enter in applyjob test id");
		app.setLoginName("Rama");
		System.out.println("enter in applyjob test name");

		System.out.println(jobDAO.applyJob(app));
		System.out.println("enter in applyjob test end");
	}

}
