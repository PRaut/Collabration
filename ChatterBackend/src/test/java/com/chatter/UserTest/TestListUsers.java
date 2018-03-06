package com.chatter.UserTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.UserDAO;
import com.chatter.model.User;

public class TestListUsers {
	private static UserDAO userDAO;
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.chatter");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testListUsers(){
		List<User> listUser = userDAO.listUsers();
		assertEquals("List User Failed", 2 , listUser.size());
	}
}
