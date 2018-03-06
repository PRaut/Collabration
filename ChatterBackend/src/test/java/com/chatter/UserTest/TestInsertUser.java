package com.chatter.UserTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.UserDAO;
import com.chatter.model.User;

public class TestInsertUser {

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
	public void testInsertUser() {
		User user = new User();
		user.setUserName("testUser 2");
		user.setPassword("123");
		user.setEmail("user2@gmail.com");
		user.setPhone("98789865");
		user.setAddress("nag");
		user.setRole("USER");
		user.setEnabled(true);
		user.setAccountOpeningDate(new Date());

		assertEquals("Insert User Failed", true, userDAO.insertUser(user));
	}

}
