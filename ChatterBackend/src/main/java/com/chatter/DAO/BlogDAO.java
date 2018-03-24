package com.chatter.DAO;

import java.util.List;

import com.chatter.model.Blog;
import com.chatter.model.BlogComment;

public interface BlogDAO {
	public boolean addBlog(Blog blog);

	public boolean deleteBlog(Blog blog);

	public boolean updateBlog(Blog blog);

	public Blog getBlog(int blogId);

	public boolean approveBlog(Blog blog);

	public boolean rejectBlog(Blog blog);

	public List<Blog> listBlog();

	//------------------------------------------
	
	public boolean incrementLikes(Blog blog);

	public boolean addBlogComment(BlogComment blogComment);

	public boolean deleteBlogComment(BlogComment blogComment);

	public BlogComment getBlogComment(int commentId);

	public List<BlogComment> listBlogComment(int blogId);
}
