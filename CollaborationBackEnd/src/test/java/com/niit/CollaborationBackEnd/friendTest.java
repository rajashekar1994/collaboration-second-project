package com.niit.CollaborationBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.ForumDAO;
import com.niit.CollaborationBackEnd.dao.FriendDAO;
import com.niit.CollaborationBackEnd.model.Forum;
import com.niit.CollaborationBackEnd.model.Friend;

public class friendTest {
	
	public static void main(String[] args) 
	{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	FriendDAO friendDAO = (FriendDAO)context.getBean("friendDAO");
	Friend friend  = (Friend)context.getBean("friend");
	

	friend.setStatus('k');
	friend.setFriend_id("54");
	friend.setUser_id("19");
	
	
	//c_Blog.setId(2);
	
//	C_Blog.setId("U_002");
//	c_User_Detail.setName("NARESH");
//	c_User_Detail.setPassword("1234");
//	c_User_Detail.setAddress("KMM");
//	c_User_Detail.setMobile("98544885");
//	c_User_Detail.setStatus("A");
//	c_User_Detail.setReason("SSSS");
//	c_User_Detail.setRole("STUDENT");
//	c_User_Detail.setIs_online("N");
	
	friendDAO.addFriend(friend);
	}

}
