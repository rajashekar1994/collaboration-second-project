package com.niit.CollaborationBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.JobDAO;
import com.niit.CollaborationBackEnd.model.Job;




public class jobTest {
	public static void main(String[] args) 
	{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	JobDAO jobDAO = (JobDAO)context.getBean("jobDAO");
	Job job  = (Job)context.getBean("job");
	
	job.setDateTime("10/03/2017");
	job.setDescription("ffvv");
	job.setStatus("cn");
	job.setTitle("jjk");
	job.setUser_id("76");
	
	
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
	
	jobDAO.addJob(job);
	}
}


