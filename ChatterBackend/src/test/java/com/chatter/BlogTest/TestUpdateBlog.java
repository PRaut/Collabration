package com.chatter.BlogTest;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.BlogDAO;
import com.chatter.model.Blog;

public class TestUpdateBlog {

	@Autowired
	public static BlogDAO blogDAO;
	
	@Autowired
	public static SessionFactory sessionFactory;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.chatter");
		context.refresh();
		
		blogDAO = (BlogDAO) context.getBean("blogDAO");
		sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	}
	
	@Test
	public void testUpdateBlog(){
		Blog blog = sessionFactory.openSession().get(Blog.class, 1);
		blog.setBlogName("Updated Blog1");
		
		blogDAO.updateBlog(blog);
		
		assertEquals("Blog Updated Failed", true, blogDAO.updateBlog(blog));
	}
}
