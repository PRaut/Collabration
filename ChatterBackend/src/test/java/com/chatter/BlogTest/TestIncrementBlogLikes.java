package com.chatter.BlogTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.BlogDAO;
import com.chatter.model.Blog;

public class TestIncrementBlogLikes {
	private static AnnotationConfigApplicationContext context;
	private static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.chatter");
		context.refresh();
		
		blogDAO = (BlogDAO) context.getBean("blogDAO");
	}
	
	@Test
	public void testIncrementLikesBlog() {
	Blog  blog=(Blog)blogDAO.getBlog(1);
	
	 assertTrue("sucessfully updated from table" ,blogDAO.incrementLikes(blog));
	}
	
}
