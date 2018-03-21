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
			System.out.println(blog.getBlogId()+ blog.getBlogName());
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
		Query query =  session.createQuery("FROM Blog");
		List<Blog> listBlog = query.list();
		return listBlog;
	}

}
