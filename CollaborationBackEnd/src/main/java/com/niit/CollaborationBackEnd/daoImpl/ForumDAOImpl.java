package com.niit.CollaborationBackEnd.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackEnd.dao.ForumDAO;
import com.niit.CollaborationBackEnd.model.Forum;



@Repository("forumDAO")
@EnableTransactionManagement
public class ForumDAOImpl implements ForumDAO{
	Logger log = LoggerFactory.getLogger(Forum.class);

	@Autowired
	SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory)
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
	public boolean addForum(Forum forum) {
		sessionFactory.getCurrentSession().save(forum);
		return false;
	}
	@Transactional
	public List<Forum> list() {
		String str="from Forum";
		Query query=sessionFactory.getCurrentSession().createQuery(str);
			return query.list();
		
	}
	@Transactional
	public boolean delete(Forum forum) {
		sessionFactory.getCurrentSession().delete(forum);
		return false;
	}

}
