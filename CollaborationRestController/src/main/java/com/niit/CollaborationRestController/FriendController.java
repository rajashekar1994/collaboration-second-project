package com.niit.CollaborationRestController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CollaborationBackEnd.dao.C_User_Detail_DAO;
import com.niit.CollaborationBackEnd.dao.FriendDAO;
import com.niit.CollaborationBackEnd.model.C_User_Detail;
import com.niit.CollaborationBackEnd.model.Friend;

@RestController
public class FriendController {
	
	Logger log=LoggerFactory.getLogger(FriendController.class);
	
	@Autowired
	FriendDAO friendDAO;
	
	@Autowired
	Friend friend;
	@Autowired
	HttpSession httpsession;
	
@Autowired
C_User_Detail_DAO c_User_Detail_DAO;
	
	
	@GetMapping("/addFriend_{user_id}")
	public ResponseEntity<Friend> sendFriendRequest(@PathVariable("user_id") String friendID) {
		log.debug("->->->->calling method sendFriendRequest "+friendID);
		String loggedInuser_id = (String) httpsession.getAttribute("id");
		friend.setUser_id(loggedInuser_id);
		friend.setFriend_id(friendID);
		friend.setStatus('N');               // N - New, R->Rejected, A->Accepted
		if(isUserExist(friendID)==false)
		{
			friend.setErrorCode("404");
			friend.setErrorMessage("No user exist with the id :" + friendID);
		}
		
		else
		if (friendDAO.get(loggedInuser_id, friendID) != null) {
			friend.setErrorCode("404");
			friend.setErrorMessage("You have already sent the friend request to " + friendID);
			friend = friendDAO.get(loggedInuser_id, friendID);
			friend.setStatus('N');
			friendDAO.update(friend);

		} else {
			friendDAO.addFriend(friend);

			friend.setErrorCode("200");
			friend.setErrorMessage("Friend request sent successfully.." + friendID);
		}

		return new ResponseEntity<Friend>(friend, HttpStatus.OK);

	}
	
	
	
	private boolean isUserExist(String id)
	{
		if(c_User_Detail_DAO.getUser(id)==null)
			return false;
		else
			return true;
	}
	
	
	@GetMapping("/listFriend")
	public ResponseEntity<List<String>>friendlist() {
		log.debug("->->->->calling method friendlist");
		String loggedInuser_id = (String) httpsession.getAttribute("id");
		List<String> friendlist = new ArrayList<String>();
		if(loggedInuser_id  == null)
		{
			friend.setErrorCode("404");
			friend.setErrorMessage("Please login to know your friends");
			//return new ResponseEntity<List<String>>(friendlist, HttpStatus.OK);
			return null;
		}
		log.debug("getting friends of : " + loggedInuser_id);
		friendlist = friendDAO.friendlist(loggedInuser_id);

		if (friendlist.isEmpty()) {
			log.debug("Friends does not exist for the user : " + loggedInuser_id);
			friend.setErrorCode("404");
			friend.setErrorMessage("You does not have any friends");
			return null;
		}
		log.debug("Send the friendlist ");
		return new ResponseEntity<List<String>>(friendlist, HttpStatus.OK);
	}

@GetMapping(value = "/unFriend/friend_id")
public ResponseEntity<Friend> unFriend(@PathVariable("friend_id") String friend_id) {
	log.debug("->->->->calling method unFriend");
	String user_id = httpsession.getAttribute("id").toString();
	friend = friendDAO.get(user_id, friend_id);
	friend.setStatus('U');
	friendDAO.update(friend);
	return new ResponseEntity<Friend>(friend, HttpStatus.OK);

}

@GetMapping(value = "/rejectFriend-{user_id}")
public ResponseEntity<Friend> rejectFriendRequest(@PathVariable("user_id") String friend_id) {
	log.debug("->->->->calling method rejectFriendRequest");
	String user_id = httpsession.getAttribute("id").toString();
	boolean b=friendDAO.rejectFriend(user_id,friend_id);
	//friend = friendDAO.get(user_id, friend_id);
	//friend.setStatus('R');
	//friendDAO.update(friend);
	if(b)
	{
		friend.setUser_id(user_id);
		friend.setFriend_id(friend_id);
	}
	return new ResponseEntity<Friend>(friend, HttpStatus.OK);

}


@GetMapping(value="/acceptFriend-{user_id}")
public ResponseEntity<Friend> acceptFriendRequest(@PathVariable("user_id") String friend_id) {
	log.debug("->->->->calling method acceptFriendRequest");
	String user_id = httpsession.getAttribute("id").toString();
	boolean b = friendDAO.accept(user_id, friend_id);
	if(b)
	{
		friend.setUser_id(user_id);
		friend.setFriend_id(friend_id);
	}
	return new ResponseEntity<Friend>(friend, HttpStatus.OK);

}


@GetMapping(value = "/pendingRequest")
public ResponseEntity<List<Friend>> pendingRequest() {
	log.debug("->->->->calling method pendingRequest");
	String loggedInuser_id = (String) httpsession.getAttribute("id");
	List<Friend>pendingRequest = friendDAO.pendingRequest(loggedInuser_id);
	return new ResponseEntity<List<Friend>>(pendingRequest, HttpStatus.OK);

}



}

