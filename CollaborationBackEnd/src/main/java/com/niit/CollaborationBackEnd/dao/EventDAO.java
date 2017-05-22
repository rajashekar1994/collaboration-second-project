package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Event;

public interface EventDAO {
	
	public boolean addEvent(Event event);
	
	public List<Event> list();

}
