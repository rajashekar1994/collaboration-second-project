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

import com.niit.CollaborationBackEnd.dao.C_User_Detail_DAO;
import com.niit.CollaborationBackEnd.model.C_User_Detail;


@Repository("c_User_Detail_DAO")
@EnableTransactionManagement

public class C_User_Detail_DAOImpl implements C_User_Detail_DAO
{
	@Autowired
	SessionFactory sessionFactory;
	public C_User_Detail_DAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private static final Logger log = LoggerFactory.getLogger(C_User_Detail_DAOImpl.class);
	
	@Transactional
	public void addUser(C_User_Detail c_User_Detail)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(c_User_Detail);
	}
	
	@Transactional

public List<C_User_Detail> list() {
		String str="from C_User_Detail";
		Query query=sessionFactory.getCurrentSession().createQuery(str);
			return query.list();
	}

	
	
	@Transactional
	public boolean validateUser(String id, String password) 
	{
		log.info("Validate User Method Started");
		try
		{
			C_User_Detail c_User_Detail =  sessionFactory.getCurrentSession().get(C_User_Detail.class, id);
			if(c_User_Detail.getPassword().equals(password))
			{
				
				log.info("Valid User");
				return true;
			}
			else
			{
				
				log.info("Invalid password");
				return false;
			}
		} catch(Exception ex)
		{
			C_User_Detail c_User_Detail = new C_User_Detail();
			
			log.error("Username Not found in database");
			return false;
		}
	}
	
	
	
	@Transactional
	public C_User_Detail getC_User_Detail(String id) 
	{
		log.debug("Starting of Method Get User "+id);
		try
		{
			C_User_Detail c_User_Detail =  sessionFactory.getCurrentSession().get(C_User_Detail.class,id );
			c_User_Detail.setErrorCode("200");
			c_User_Detail.setErrorMessage("User Found");
			return c_User_Detail;
		}
		catch(Exception ex)
		{
			C_User_Detail c_User_Detail = new C_User_Detail();
			ex.printStackTrace();
			c_User_Detail.setErrorCode("404");
			c_User_Detail.setErrorMessage("User Not Found");
			return null;
		}
	}

	@Transactional
	public C_User_Detail getUser(String id) {
		
		return(C_User_Detail)sessionFactory.getCurrentSession().get(C_User_Detail.class,id);
	}

	public void update(C_User_Detail c_User_Detail) {
		// TODO Auto-generated method stub
		
	}



}
