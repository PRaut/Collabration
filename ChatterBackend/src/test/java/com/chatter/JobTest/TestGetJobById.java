package com.chatter.JobTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.JobDAO;
import com.chatter.config.DBConfig;
import com.chatter.model.Job;

public class TestGetJobById {
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
	public void testGetJobById(){
		Job job = jobDAO.getJob(1);
		assertEquals("Issue in get Job by Id ", "PR SOLns", job.getCompany());
	}
}
