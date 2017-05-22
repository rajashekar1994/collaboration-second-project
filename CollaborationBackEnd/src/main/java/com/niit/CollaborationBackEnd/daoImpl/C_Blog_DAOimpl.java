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

import com.niit.CollaborationBackEnd.dao.C_Blog_DAO;
import com.niit.CollaborationBackEnd.model.C_Blog;


@Repository("c_Blog_DAO")
@EnableTransactionManagement
public class C_Blog_DAOimpl implements C_Blog_DAO
{
	
Logger log = LoggerFactory.getLogger(C_Blog_DAOimpl.class);

@Autowired
SessionFactory sessionFactory;

public C_Blog_DAOimpl(SessionFactory sessionFactory)
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
	public List<C_Blog>list() {
		String str="from C_Blog";
		Query query=sessionFactory.getCurrentSession().createQuery(str);
			return query.list();
	}
		
	

	
	@Transactional
	public boolean delete(C_Blog c_Blog) {
		sessionFactory.getCurrentSession().delete(c_Blog);
		return false;
	}


	@Transactional
	public boolean addBlog(C_Blog c_Blog) 
	{
		sessionFactory.getCurrentSession().save(c_Blog);
		return false;
	}

}
