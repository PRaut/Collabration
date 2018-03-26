package com.chatter.BlogTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.BlogDAO;
import com.chatter.model.BlogComment;

public class TestGetBlogComments {
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
	public void testGetByIdBlogComment() {
		BlogComment blogComment = new BlogComment();

		blogComment = (BlogComment) blogDAO.getBlogComment(2);

		System.out.println("ID: " + blogComment.getBlogId() + ",UserName: " + blogComment.getUserName() + ", Comments:"
				+ blogComment.getCommentText());
	}

}
