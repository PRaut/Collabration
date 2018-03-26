package com.chatter.BlogTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.BlogDAO;
import com.chatter.model.BlogComment;

public class TestListBlogComments {
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
	public void testGetBlogCommentListById() {
		BlogComment blogComment = new BlogComment();
		List<BlogComment> listBlogcomment = blogDAO.listBlogComment(1);
		assertTrue("List of blogComment data display", listBlogcomment.size() > 0);
		for (BlogComment blogComments : listBlogcomment) {
			System.out.println(blogComments.getCommentId() + "::");
			System.out.println(blogComments.getCommentText() + "::");
			System.out.println(blogComments.getUserName() + "::");
		}
	}
}
