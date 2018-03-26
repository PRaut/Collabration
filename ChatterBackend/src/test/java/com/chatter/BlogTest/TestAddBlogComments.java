package com.chatter.BlogTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.BlogDAO;
import com.chatter.model.BlogComment;

public class TestAddBlogComments {
	private static AnnotationConfigApplicationContext context;
	private static BlogDAO blogDAO;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.chatter");
		context.refresh();

		blogDAO = (BlogDAO) context.getBean("blogDAO");
	}

	@Test
	public void testAddBlogComment() {

		BlogComment blogComment = new BlogComment();

		blogComment.setCommentDate(new java.util.Date());
		blogComment.setBlogId(1);
		blogComment.setCommentText("Truly said");
		blogComment.setUserName("Vina");

		assertTrue("Data inserted in blogComment Issue", blogDAO.addBlogComment(blogComment));

	}
}
