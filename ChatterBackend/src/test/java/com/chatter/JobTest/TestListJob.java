package com.chatter.JobTest;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.JobDAO;
import com.chatter.model.Job;

public class TestListJob {
	@Autowired
	public static SessionFactory sessionFactory;

	@Autowired
	public static JobDAO jobDAO;

	public static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.chatter");
		context.refresh();

		jobDAO = (JobDAO) context.getBean("jobDAO");
		sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	}

	@Test
	public void testListJobs(){
		List<Job> listJob = jobDAO.listJob();
		assertEquals("List job Failed", 2, listJob.size());
	}
}
