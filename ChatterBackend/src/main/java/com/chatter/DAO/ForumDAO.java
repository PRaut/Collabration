package com.chatter.DAO;

import java.util.List;

import com.chatter.model.Forum;

public interface ForumDAO {
	public boolean addForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public boolean updateForum(Forum forum);
	public Forum getForum(int forumId);
	public boolean approveForum(Forum forum);
	public boolean rejectForum(Forum forum);
	public List<Forum> listForum();
}