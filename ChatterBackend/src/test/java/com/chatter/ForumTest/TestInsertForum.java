package com.chatter.ForumTest;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.ForumDAO;
import com.chatter.model.Forum;

public class TestInsertForum {

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
	}

	@Test
	public void testInsertForum() {
		/*Forum forum = new Forum();
		forum.setForumName("Forum 1");
		forum.setForumContent("This is forum content 1");
		forum.setCreatedDate(new Date());
		forum.setUserName("Forum User 1");
		forum.setStatus("A");*/
		
		Forum forum = new Forum();
		forum.setForumName("Forum 2");
		forum.setForumContent("This is forum content 2");
		forum.setCreatedDate(new Date());
		forum.setUserName("Forum User 2");
		forum.setStatus("NA");
		assertEquals("Insert Forum Failed", true, forumDAO.addForum(forum));
	}
}
