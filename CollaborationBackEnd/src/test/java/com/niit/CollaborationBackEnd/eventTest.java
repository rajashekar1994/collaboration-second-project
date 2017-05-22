package com.niit.CollaborationBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.EventDAO;

import com.niit.CollaborationBackEnd.model.Event;

public class eventTest {
	

	public static void main(String[] args) 
	{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	EventDAO eventDAO = (EventDAO)context.getBean("eventDAO");
	Event event = (Event)context.getBean("event");
	

	event.setDescription("gud");
	event.setDate_time("14/03/2017");
	event.setName("bdy");
	event.setVenue("kmm");
	
	
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
	
	eventDAO.addEvent(event);
	}


}
