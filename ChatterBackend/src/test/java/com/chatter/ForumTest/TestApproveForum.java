package com.chatter.ForumTest;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.ForumDAO;
import com.chatter.model.Forum;

public class TestApproveForum {
	@Autowired
	public static ForumDAO forumDAO;

	@Autowired
	public static SessionFactory sessionFactory;
	public static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.chatter");
		context.refresh();

		forumDAO = (ForumDAO) context.getBean("forumDAO");
		sessionFactory = (SessionFactory)context.getBean("sessionFactory");
	}

	@Test
	public void testApproveForum(){
		Forum forum = sessionFactory.openSession().get(Forum.class, 4);
		forum.setStatus("A");
		
		assertEquals("Failed Approve Forum", true, forumDAO.approveForum(forum));
	}
}
