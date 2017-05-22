package com.niit.CollaborationRestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.niit.CollaborationBackEnd.dao.JobDAO;

import com.niit.CollaborationBackEnd.model.Job;

@RestController
public class JobController {
	@Autowired
	JobDAO jobDAO;
	
	@Autowired
	Job job;
	
	@PostMapping("/addJob")
	public ResponseEntity<Job> addForum(@RequestBody Job job){
		
	
		job.setStatus("p");
		
		
		jobDAO.addJob(job);

		job.setErrorCode("200");
		job.setErrorMessage("success");
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
	@GetMapping("/listJob")
	public ResponseEntity<List<Job>> getJob()
	{
		List<Job> li = jobDAO.list();
		
		return new ResponseEntity<List<Job>>(li,HttpStatus.OK); 
	}
}




