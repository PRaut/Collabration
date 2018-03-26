package com.chatter.BlogTest;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.BlogDAO;
import com.chatter.model.BlogComment;

public class TestDeleteBlogComments {
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
	public void testDeleteBlogComment() {

		BlogComment blogComment = new BlogComment();

		blogComment = blogDAO.getBlogComment(1);

		assertTrue("BlogComment Deleted Issue", blogDAO.deleteBlogComment(blogComment));

	}
}
