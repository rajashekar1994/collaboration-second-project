package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Job;

public interface JobDAO {
public boolean addJob(Job job);
	
	public List<Job> list();	
	
	public boolean delete(Job job);

}
