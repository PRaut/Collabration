package com.chatter.BlogTest;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.BlogDAO;
import com.chatter.model.Blog;

public class TestDeleteBlog {
	@Autowired
	public static BlogDAO blogDAO;

	@Autowired
	public static SessionFactory sessionFactory;

	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.chatter");
		context.refresh();

		blogDAO = (BlogDAO) context.getBean("blogDAO");
		sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	}
	
	@Test
	public void testDeleteBlog(){
		Blog blog = sessionFactory.openSession().get(Blog.class, 2);
		assertEquals("Delete Blog Fail", true, blogDAO.deleteBlog(blog));
	}
}
