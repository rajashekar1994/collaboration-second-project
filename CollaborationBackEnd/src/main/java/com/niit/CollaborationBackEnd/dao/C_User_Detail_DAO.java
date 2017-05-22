package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.C_User_Detail;

public interface C_User_Detail_DAO 
{
	public void addUser(C_User_Detail c_User_Detail);
	
	public List<C_User_Detail> list();
	
	public boolean validateUser(String userName, String password);
	
	public C_User_Detail getC_User_Detail(String id);

	public C_User_Detail getUser(String id);
	
	public void update(C_User_Detail c_User_Detail);
	
}
