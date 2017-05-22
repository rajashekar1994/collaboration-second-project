package com.niit.CollaborationBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackEnd.dao.C_User_Detail_DAO;
import com.niit.CollaborationBackEnd.model.C_User_Detail;

public class C_Uer_DetailTest {

	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		C_User_Detail_DAO c_User_Detail_DAO = (C_User_Detail_DAO)context.getBean("c_User_Detail_DAO");
		C_User_Detail c_User_Detail = (C_User_Detail)context.getBean("c_User_Detail");
		
		c_User_Detail.setId("shekar.chennapai");
		c_User_Detail.setName("rajashekar");
		c_User_Detail.setPassword("raj1994");
		c_User_Detail.setAddress("huzurnagar");
		c_User_Detail.setMobile("8187007009");
		c_User_Detail.setStatus("A");
		c_User_Detail.setReason("RRRRRR");
		c_User_Detail.setRole("ADMIN");
		c_User_Detail.setIs_online("Y");
		
		
		/*c_User_Detail.setId("U_002");
		c_User_Detail.setName("NARESH");
		c_User_Detail.setPassword("1234");
		c_User_Detail.setAddress("KMM");
		c_User_Detail.setMobile("98544885");
		c_User_Detail.setStatus("A");
		c_User_Detail.setReason("SSSS");
		c_User_Detail.setRole("STUDENT");
		c_User_Detail.setIs_online("N");*/
		
		c_User_Detail_DAO.addUser(c_User_Detail);
		

		List<C_User_Detail> u= c_User_Detail_DAO.list();
		for(C_User_Detail m: u)
			System.out.println(m.getId()+" \t"+m.getName()+"\t");
			//c_User_Detail_DAO.addUser(c_User_Detail);
		
		//userDao.delete(user);
		
	}

}
