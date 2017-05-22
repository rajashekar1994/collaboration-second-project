package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Friend;

public interface FriendDAO {
	
	public boolean addFriend(Friend friend);
	
	public List<String>friendlist(String user_id);
	
	public boolean update(Friend friend);
	
	public boolean accept(String user_id, String friend_id);
	
	public Friend get(String user_id, String friend_id);
	
	public List<Friend> pendingRequest(String friend_id);
	
	public boolean rejectFriend(String user_id, String friend_id);

	
	}


