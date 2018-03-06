package com.chatter.UserTest;


import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.UserDAO;
import com.chatter.model.User;

public class TestGetUser {
	@Autowired
	private static SessionFactory sessionFactory;
	private static UserDAO userDAO;
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.chatter");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("UserDAO");
		sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	}
	
	@Test
	public void testGetUser(){
		User user = sessionFactory.openSession().get(User.class, 1);
		assertEquals("Get User Failed", "Updated User" ,user.getUserName());
	}
}
