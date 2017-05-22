package com.niit.CollaborationBackEnd.dao;

import java.util.List;


import com.niit.CollaborationBackEnd.model.Forum;

public interface ForumDAO {
public boolean addForum(Forum forum);
	
	public List<Forum> list();	
	
	public boolean delete(Forum forum);
	

}
