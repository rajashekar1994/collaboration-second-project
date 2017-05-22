package com.niit.CollaborationBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.C_Blog_DAO;
import com.niit.CollaborationBackEnd.dao.ForumDAO;
import com.niit.CollaborationBackEnd.model.C_Blog;
import com.niit.CollaborationBackEnd.model.Forum;

public class forumTest {
	public static void main(String[] args) 
	{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	ForumDAO forumDAO = (ForumDAO)context.getBean("forumDAO");
	Forum forum  = (Forum)context.getBean("forum");
	
	forum.setDateTime("09/03/2017");
	forum.setDescription("zxcv");
	forum.setStatus('j');
	forum.setTitle("dsfxg");
	forum.setUserId("66");
	
	
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
	
	forumDAO.addForum(forum);
	}
}

