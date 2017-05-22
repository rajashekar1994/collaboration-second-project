package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.C_Blog;

public interface C_Blog_DAO {

	public boolean addBlog(C_Blog c_Blog);
	
	public List<C_Blog> list();	
	
	public boolean delete(C_Blog c_Blog);
	

}
