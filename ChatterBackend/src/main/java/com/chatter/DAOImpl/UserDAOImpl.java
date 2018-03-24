package com.chatter.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chatter.DAO.UserDAO;
import com.chatter.model.User;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean insertUser(User user) {
		try{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateUser(User user) {
		try{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteUser(User user) {
		try{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public User getUser(int userId) {
		User user = sessionFactory.getCurrentSession().get(User.class, userId);
		return user;
	}

	@Override
	public List<User> listUsers() {
		List<User> listUser = sessionFactory.openSession().createQuery("FROM User").list();
		return listUser;
	}

}
