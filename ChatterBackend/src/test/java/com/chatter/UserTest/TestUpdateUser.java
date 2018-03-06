package com.chatter.UserTest;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.UserDAO;
import com.chatter.model.User;

import static org.junit.Assert.assertEquals;

public class TestUpdateUser {

	@Autowired
	private static SessionFactory sessionFactory;

	private static UserDAO userDAO;
	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.chatter");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
		sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	}

	@Test
	public void testUpdateUser() {
		User user = sessionFactory.openSession().get(User.class, 1);
		user.setUserName("Updated User");

		assertEquals("Update User Failed", true, userDAO.updateUser(user));
	}

}
