package com.chatter.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteUser(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
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

	// -----------------------------------

	@Override
	public boolean checkLogin(User user) {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from User where userName=:loginName and password=:pass");
			query.setParameter("loginName", user.getUserName());
			query.setParameter("pass", user.getPassword());
			User users = (User) query.list().get(0);
			if (users == null)
				return false;
			else
				return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateOnlineStatus(String status, User user) {
		try {
			user.setIsOnline(status);
			sessionFactory.getCurrentSession().update(user);
			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public User getUserByLoginName(String loginName) {
		try {
			Session session = sessionFactory.openSession();
			System.out.println("In getUserByLoginName " + loginName);
			Query query = session.createQuery("FROM User WHERE userName=:loginName");
			query.setParameter("loginName", loginName);
			User user = (User) query.list().get(0);
			System.out.println("user got "+ user.getUserName());
			session.close();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

}
