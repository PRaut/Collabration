package com.chatter.DAO;

import java.util.List;

import com.chatter.model.User;

public interface UserDAO {
	public boolean insertUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public User getUser(int userId);
	public List<User> listUsers();
	
	//-----------------------
	public boolean checkLogin(User user);
	public boolean updateOnlineStatus(String status, User user);
	public User getUserByLoginName(String loginName);
}
