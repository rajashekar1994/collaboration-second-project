package com.niit.CollaborationRestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CollaborationBackEnd.dao.C_Blog_DAO;
import com.niit.CollaborationBackEnd.model.C_Blog;


@RestController
public class BlogController {
	@Autowired
	C_Blog_DAO c_Blog_DAO;
	
	@Autowired
	C_Blog c_Blog;
	
	@PostMapping("/addBlog")
	public ResponseEntity<C_Blog> addUser(@RequestBody C_Blog c_Blog){
		
		c_Blog.setReason("social");
		c_Blog.setStatus('P');
		
		
		c_Blog_DAO.addBlog(c_Blog);

		c_Blog.setErrorCode("200");
		c_Blog.setErrorMessage("success");
		return new ResponseEntity<C_Blog>(c_Blog,HttpStatus.OK);
	}
	
	@GetMapping("/listBlog")
	public ResponseEntity<List<C_Blog>> getBlogs()
	{
		List<C_Blog> li = c_Blog_DAO.list();
		
		return new ResponseEntity<List<C_Blog>>(li,HttpStatus.OK); 
	}
}



