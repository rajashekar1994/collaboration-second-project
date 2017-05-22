package com.niit.CollaborationRestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CollaborationBackEnd.dao.EventDAO;
import com.niit.CollaborationBackEnd.model.Event;

@RestController
public class EventController {
	
	@Autowired
	EventDAO eventDAO;
	
	@Autowired
	Event event;
	
	
	@PostMapping("/addEvent")
	public ResponseEntity<Event> addEvent(@RequestBody Event event){
		
	
		//forum.setStatus('P');
		
		
		eventDAO.addEvent(event);

		event.setErrorCode("200");
		event.setErrorMessage("success");
		return new ResponseEntity<Event>(event,HttpStatus.OK);
	}
	
	@GetMapping("/listEvent")
	public ResponseEntity<List<Event>> getEvent()
	{
		List<Event> li = eventDAO.list();
		
		return new ResponseEntity<List<Event>>(li,HttpStatus.OK); 
	}
	

}
