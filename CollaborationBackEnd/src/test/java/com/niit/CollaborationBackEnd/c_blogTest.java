package com.niit.CollaborationBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.C_Blog_DAO;

import com.niit.CollaborationBackEnd.model.C_Blog;


public class c_blogTest {

	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		C_Blog_DAO c_Blog_DAO = (C_Blog_DAO)context.getBean("c_Blog_DAO");
		C_Blog c_Blog  = (C_Blog)context.getBean("c_Blog");
		
		//c_Blog.setId(2);
		c_Blog.setTitle("naresh");
		c_Blog.setUserId("U_003");;
		c_Blog.setDateTime("08/03/2017");;
		c_Blog.setStatus('A');
		c_Blog.setReason("kkk");
		c_Blog.setDescription("job");
		
//		C_Blog.setId("U_002");
//		c_User_Detail.setName("NARESH");
//		c_User_Detail.setPassword("1234");
//		c_User_Detail.setAddress("KMM");
//		c_User_Detail.setMobile("98544885");
//		c_User_Detail.setStatus("A");
//		c_User_Detail.setReason("SSSS");
//		c_User_Detail.setRole("STUDENT");
//		c_User_Detail.setIs_online("N");
		
		c_Blog_DAO.addBlog(c_Blog);
		

		//List<C_User_Detail> u= c_User_Detail_DAO.list();
		//for(C_User_Detail m: u)
			//System.out.println(m.getId()+" \t"+m.getName()+"\t");
			//c_User_Detail_DAO.addUser(c_User_Detail);
		
		//userDao.delete(user);
		
	
}
}