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

import com.niit.CollaborationBackEnd.dao.EventDAO;
import com.niit.CollaborationBackEnd.model.Event;

@Repository("eventDAO")
@EnableTransactionManagement
public class EventDAOImpl implements EventDAO {

	Logger log = LoggerFactory.getLogger(Event.class);

	@Autowired
	SessionFactory sessionFactory;

	public EventDAOImpl(SessionFactory sessionFactory) {
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			log.error("unable to connect to database");
			e.printStackTrace();
		}
	}

	@Transactional
	public boolean addEvent(Event event) {
		sessionFactory.getCurrentSession().save(event);
		return false;
	}

	@Transactional
	public List<Event> list() {
		String str = "from Event";
		Query query = sessionFactory.getCurrentSession().createQuery(str);
		return query.list();

	}

}
