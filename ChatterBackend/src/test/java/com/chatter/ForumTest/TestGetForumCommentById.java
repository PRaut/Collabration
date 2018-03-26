package com.chatter.ForumTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.ForumDAO;
import com.chatter.config.DBConfig;
import com.chatter.model.ForumComment;

public class TestGetForumCommentById {
	private static DBConfig config;
	private static ForumDAO forumDAO;

	@BeforeClass
	public static void setUp() {
		config = new DBConfig();

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.chatter");
		context.refresh();

		forumDAO = (ForumDAO) context.getBean("forumDAO");
	}

	@Test
	public void testForumCommentById() {

		ForumComment forumComment= new ForumComment();
		forumComment=(ForumComment)forumDAO.getForumComment(2);
		 System.out.println("ID: "+forumComment.getCommentId()+ ",UserName: " +forumComment.getUserName() 
		 + " ,CommentText:"+forumComment.getCommentText());
	}
}
