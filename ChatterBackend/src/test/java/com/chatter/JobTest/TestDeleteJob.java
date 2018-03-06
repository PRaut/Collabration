package com.chatter.JobTest;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.JobDAO;
import com.chatter.model.Job;

public class TestDeleteJob {

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
	public void testDeleteJob(){
		Job job = sessionFactory.openSession().get(Job.class,2);
		assertEquals("Delete Job Failed", true, jobDAO.deleteJob(job));
	}

}
