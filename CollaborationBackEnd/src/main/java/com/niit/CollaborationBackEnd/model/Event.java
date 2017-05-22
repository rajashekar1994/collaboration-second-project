package com.niit.CollaborationBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Entity
@Component
public class Event extends BaseDomain {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	private String name;
	private String description;
	private String venue;
	private String date_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
	
	

}
