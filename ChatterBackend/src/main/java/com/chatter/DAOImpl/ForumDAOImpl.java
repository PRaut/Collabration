package com.chatter.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chatter.DAO.ForumDAO;
import com.chatter.model.Forum;

@Repository("ForumDAO")
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean addForum(Forum forum) {
		try{
			sessionFactory.getCurrentSession().save(forum);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteForum(Forum forum) {
		try{
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		}catch(Exception ex){
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateForum(Forum forum) {
		try{
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}catch(Exception ex){
			return false;
		}
	}

	@Override
	public Forum getForum(int forumId) {
		Forum forum = (Forum) sessionFactory.getCurrentSession().get(Forum.class, forumId);
		return forum;
	}

	@Transactional
	@Override
	public boolean approveForum(Forum forum) {
		try{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}catch(Exception ex){
			return false;
		}
	}

	@Transactional
	@Override
	public boolean rejectForum(Forum forum) {
		try{
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Forum> listForum() {
		List<Forum> listForum = sessionFactory.openSession().createQuery("FROM Forum").list();
		return listForum;
	}

}
