package com.chatter.DAO;

import java.util.List;

import com.chatter.model.Forum;
import com.chatter.model.ForumComment;

public interface ForumDAO {
	public boolean addForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public boolean updateForum(Forum forum);
	public Forum getForum(int forumId);
	public boolean approveForum(Forum forum);
	public boolean rejectForum(Forum forum);
	public List<Forum> listForum();
	
	//------------------------------------------
	public boolean addForumComment(ForumComment forumComment);
	public boolean deleteForumComment(ForumComment forumComment);
	public ForumComment getForumComment(int commentId);
	public List<ForumComment>listForumComment (int forumId);
}
