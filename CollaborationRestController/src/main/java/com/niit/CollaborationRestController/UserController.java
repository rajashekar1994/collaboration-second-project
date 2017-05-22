package com.niit.CollaborationRestController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CollaborationBackEnd.dao.C_User_Detail_DAO;
import com.niit.CollaborationBackEnd.daoImpl.C_User_Detail_DAOImpl;
import com.niit.CollaborationBackEnd.model.C_User_Detail;

@RestController
public class UserController {
	
	@Autowired
	C_User_Detail_DAO c_User_Detail_DAO;
	
	@Autowired
	C_User_Detail c_User_Detail;
	
	@Autowired
	HttpSession session;
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/addUser")
	public ResponseEntity<C_User_Detail> addUser(@RequestBody C_User_Detail c_User_Detail){
		
		c_User_Detail.setStatus("A");
		c_User_Detail_DAO.addUser(c_User_Detail);

		c_User_Detail.setErrorCode("200");
		c_User_Detail.setErrorMessage("success");
		return new ResponseEntity<C_User_Detail>(c_User_Detail,HttpStatus.OK);
	}
	
	@GetMapping("/listUser")
	public ResponseEntity<List<C_User_Detail>> getUsers()
	{
		List<C_User_Detail> li = c_User_Detail_DAO.list();
		
		return new ResponseEntity<List<C_User_Detail>>(li,HttpStatus.OK); 
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<C_User_Detail> validateUser(@RequestBody C_User_Detail c_User_Detail) 
	{
		System.out.println("ID - "+c_User_Detail.getId());
		System.out.println("Password "+c_User_Detail.getPassword());
		boolean value = c_User_Detail_DAO.validateUser(c_User_Detail.getId(), c_User_Detail.getPassword());
		System.out.println(value);
		if (value == false) 
		{
			c_User_Detail = new C_User_Detail();
			c_User_Detail.setErrorCode("404");
			c_User_Detail.setErrorMessage("Wrong username or password.");
			
		}
		else
		{
			if(c_User_Detail.getStatus().equals("R"))
			{
				c_User_Detail = new C_User_Detail();
				c_User_Detail.setErrorCode("404");
				c_User_Detail.setErrorMessage("Registeration is rejected. Please Contact Admin");
			}
			if(c_User_Detail.getStatus().equals("N"))
			{
				c_User_Detail = new C_User_Detail();
				c_User_Detail.setErrorCode("404");
				c_User_Detail.setErrorMessage("Registeration approval is pending. Please try again later");
			}
			else
			{
				c_User_Detail = c_User_Detail_DAO.getC_User_Detail(c_User_Detail.getId());
				c_User_Detail.setIs_online("Y");
				c_User_Detail_DAO.addUser(c_User_Detail);
				session.setAttribute("id", c_User_Detail.getId());
					session.setAttribute("role", c_User_Detail.getRole());
					session.setAttribute("isLoggedIn", "true");
					c_User_Detail.setErrorCode("200");
					c_User_Detail.setErrorMessage("Success");
				System.out.println("Name = "+session.getAttribute("id").toString());
				System.out.println("Role = "+session.getAttribute("role").toString());
			}
		}

		return new ResponseEntity<C_User_Detail>(c_User_Detail, HttpStatus.OK);
	}

	
	@GetMapping("/logout")
	public ResponseEntity<C_User_Detail> logout()
	{
		log.info("isLoggedIN - "+session.getAttribute("isLoggedIn"));
		if(session.getAttribute("isLoggedIn") != null)
		{
			c_User_Detail = c_User_Detail_DAO.getC_User_Detail(session.getAttribute("id").toString());
			c_User_Detail.setIs_online("N");
			c_User_Detail_DAO.addUser(c_User_Detail);
			c_User_Detail = new C_User_Detail();
			c_User_Detail.setErrorCode("200");
			c_User_Detail.setErrorMessage("You have logged out.");
			session.invalidate();
		}
		else
		{
			c_User_Detail = new C_User_Detail();
			c_User_Detail.setErrorCode("500");
			c_User_Detail.setErrorMessage("You have not logged in");
			log.info(c_User_Detail.getErrorMessage());
		}
		return new ResponseEntity<C_User_Detail>(c_User_Detail, HttpStatus.OK);
	}

	
	
	
	
	
}
