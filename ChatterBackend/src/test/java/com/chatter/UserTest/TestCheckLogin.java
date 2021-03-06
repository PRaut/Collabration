package com.chatter.UserTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.UserDAO;
import com.chatter.model.User;

public class TestCheckLogin {
	@Autowired
	public static UserDAO userDAO;
	public static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.chatter");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void testCheckUserCredentials(){
		User user = userDAO.getUser(1);
		assertEquals("Check login Failed", true, userDAO.checkLogin(user));
	}
}
