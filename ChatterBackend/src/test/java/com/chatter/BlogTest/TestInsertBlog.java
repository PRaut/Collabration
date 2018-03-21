package com.chatter.BlogTest;


import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chatter.DAO.BlogDAO;
import com.chatter.DAOImpl.BlogDAOImpl;
import com.chatter.model.Blog;

import oracle.net.aso.d;

public class TestInsertBlog {

	@Autowired
	public static BlogDAO blogDAO;
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.chatter");
		context.refresh();
		blogDAO = (BlogDAO) context.getBean("blogDAO");
		//blogDAO = new BlogDAOImpl();
	}
	
	@Test
	public void testAddBlog() throws ParseException{
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//		Date currentDate = dateFormat.parse("2018-03-04");
		
		/*Blog blog = new Blog();
		blog.setBlogName("Test 1");
		blog.setBlogContent("This is test blog 1");
		blog.setCreatedDate(new Date());
		blog.setUserName("Vina");
		blog.setStatus("A");
		blog.setLikes(0);*/
		
		Blog blog = new Blog();
		blog.setBlogName("Test 2");
		blog.setBlogContent("This is test blog 2");
		blog.setCreatedDate(new Date());
		blog.setUserName("Shubham");
		blog.setStatus("NA");
		blog.setLikes(0);
		
		/*Blog blog = new Blog();
		blog.setBlogName("Test 3");
		blog.setBlogContent("This is test blog 3");
		blog.setCreatedDate(new Date());
		blog.setUserName("Pritam");
		blog.setStatus("NA");
		blog.setLikes(0);*/
		
		assertTrue(blogDAO.addBlog(blog));
	}
}

