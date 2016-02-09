package com.note.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.note.spring.model.User;


public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(User usr) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(usr);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public User getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		User user = (User) session.get(User.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<User> userList = session.createCriteria(User.class)
				.list();
		tx.commit();
		session.close();
		return userList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.get(User.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
