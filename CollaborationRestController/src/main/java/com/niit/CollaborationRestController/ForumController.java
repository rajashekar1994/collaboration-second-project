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
import com.niit.CollaborationBackEnd.dao.ForumDAO;
import com.niit.CollaborationBackEnd.model.C_Blog;
import com.niit.CollaborationBackEnd.model.Forum;

@RestController
public class ForumController {
	@Autowired
	ForumDAO forumDAO;
	
	@Autowired
	Forum forum;
	
	@PostMapping("/addForum")
	public ResponseEntity<Forum> addForum(@RequestBody Forum forum){
		
	
		forum.setStatus('P');
		
		
		forumDAO.addForum(forum);

		forum.setErrorCode("200");
		forum.setErrorMessage("success");
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
	
	@GetMapping("/listForum")
	public ResponseEntity<List<Forum>> getForum()
	{
		List<Forum> li = forumDAO.list();
		
		return new ResponseEntity<List<Forum>>(li,HttpStatus.OK); 
	}
}



