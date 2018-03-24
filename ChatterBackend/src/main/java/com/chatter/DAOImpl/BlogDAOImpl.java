package com.chatter.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chatter.DAO.BlogDAO;
import com.chatter.model.Blog;
import com.chatter.model.BlogComment;

@Repository("BlogDAO")
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public boolean addBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(blog.getBlogId() + blog.getBlogName());
			return false;
		}

	}

	@Transactional
	@Override
	public boolean deleteBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean approveBlog(Blog blog) {
		try {
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public Blog getBlog(int blogId) {
		Blog blog = sessionFactory.getCurrentSession().get(Blog.class, blogId);
		return blog;
	}

	@Transactional
	@Override
	public boolean rejectBlog(Blog blog) {
		try {
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Blog> listBlog() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Blog");
		List<Blog> listBlog = query.list();
		return listBlog;
	}

	@Transactional
	public boolean incrementLikes(Blog blog) {
		try {
			int likes = blog.getLikes();
			likes++;
			blog.setLikes(likes);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Transactional
	public boolean addBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Transactional
	public boolean deleteBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public BlogComment getBlogComment(int commentId) {
		try {
			Session session = sessionFactory.openSession();
			BlogComment blogComment = session.get(BlogComment.class, commentId);
			session.close();
			return blogComment;
		} catch (Exception e) {
			return null;
		}

	}

	public List<BlogComment> listBlogComment(int blogId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from BlogComment where blogId=:blogId");
		query.setParameter("blogId", blogId);
		List<BlogComment> listBlogComment = query.list();
		return listBlogComment;
	}

}
