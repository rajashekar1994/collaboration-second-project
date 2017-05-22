package com.niit.CollaborationBackEnd.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackEnd.dao.FriendDAO;

import com.niit.CollaborationBackEnd.model.Friend;
import com.niit.CollaborationBackEnd.model.Job;

@Repository("friendDAO")
@EnableTransactionManagement
public class FriendDAOImpl implements FriendDAO{
	
	Logger log = LoggerFactory.getLogger(Friend.class);

	@Autowired
	SessionFactory sessionFactory;

	public FriendDAOImpl(SessionFactory sessionFactory)
	{
		try{
			this.sessionFactory=sessionFactory;
		}catch(Exception e)
		{
			log.error("unable to connect to database");
			e.printStackTrace();
		}
		}
	
	@Transactional
	public boolean addFriend(Friend friend) {
		sessionFactory.getCurrentSession().save(friend);
		return false;
	}
	@Transactional
	public List<String>friendlist(String user_id) 
	{
		String hql1=" select friend_id from  Friend where user_id='"+user_id+ "' and status='A'";
		String hql2=" select user_id from  Friend where friend_id='"+user_id+ "' and status='A'";
		log.debug("friendlist hql1:"+hql1);
		log.debug("friendlist hql2:"+hql2);
		List<String>list1=sessionFactory.getCurrentSession().createQuery(hql1).list();
		List<String>list2=sessionFactory.getCurrentSession().createQuery(hql2).list();
		list1.addAll(list2);
		return list1;
	}

		@Transactional
	public boolean update(Friend friend) {
			try {
				log.debug("starting of the method update");
				log.debug("user_id:" +friend.getUser_id() + "friend_id :"+ friend.getFriend_id());
				sessionFactory.getCurrentSession().update(friend);
				log.debug("Successfully updated");
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				log.debug("unable to update the status");
				return false;
			}
			
		
	}
		@Transactional
	public Friend get(String user_id, String friend_id) {
			try
			{
				String sql  = "FROM Friend WHERE user_id= '"+user_id+"' and friend_id = '"+friend_id+"'";
				@SuppressWarnings("rawtypes")
				Query query = sessionFactory.getCurrentSession().createQuery(sql);
				System.out.println("This - "+query.list());
				List<Friend> list = (List<Friend>) query.list();
					if(query.list().isEmpty())
					{
						String sql2  = "FROM Friend WHERE friend_id= '"+user_id+"' and user_id = '"+friend_id+"'";
						@SuppressWarnings("rawtypes")
						Query query2 = sessionFactory.getCurrentSession().createQuery(sql2);
						list = (List<Friend>) query2.list();

						if(!list.isEmpty())
						{	
							log.info("Friend Column is not available......");
							return list.get(0);
						}
					}
				log.info("Friend column found");
				 return list.get(0);
			}	
			catch(Exception e)
			{
				log.error("Friend Column is not available.");
				e.printStackTrace();
				return null;
			}
	}

		
		
		
			@Transactional
	public List<Friend> pendingRequest(String user_id) {
				String hql  = "FROM Friend WHERE friend_id= "+"'" +user_id+"'and status='"+"N'";
				log.debug(hql);
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
				 List<Friend>list=(List<Friend>)query.list();
				 return list;
			}
			
			@Transactional
			public boolean accept(String user_id, String friend_id)
			{
				try {
					String sql = "UPDATE Friend SET status = 'A' where user_id = '"+friend_id+"' and friend_id='"+user_id+"'";
					Query query = sessionFactory.getCurrentSession().createQuery(sql);
					query.executeUpdate();
					return true;
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
			
			
			@Transactional
			public boolean rejectFriend(String user_id, String friend_id)
			{
				try {
					String sql = "UPDATE Friend SET status = 'R' where user_id = '"+friend_id+"' and friend_id='"+user_id+"'";
					Query query = sessionFactory.getCurrentSession().createQuery(sql);
					query.executeUpdate();
					return true;
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
			
}

	


