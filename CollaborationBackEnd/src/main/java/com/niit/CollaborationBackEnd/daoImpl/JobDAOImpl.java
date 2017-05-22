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

import com.niit.CollaborationBackEnd.dao.JobDAO;

import com.niit.CollaborationBackEnd.model.Job;
@Repository("jobDAO")
@EnableTransactionManagement

public class JobDAOImpl implements JobDAO {
	
	Logger log = LoggerFactory.getLogger(Job.class);

	@Autowired
	SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory)
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

	public boolean addJob(Job job) {
		sessionFactory.getCurrentSession().save(job);
		return false;
	}
	@Transactional
	public List<Job> list() {
		String str="from Job";
		Query query=sessionFactory.getCurrentSession().createQuery(str);
			return query.list();
		
	}
	@Transactional
	public boolean delete(Job job) {
		sessionFactory.getCurrentSession().delete(job);
		return false;
	}

}
