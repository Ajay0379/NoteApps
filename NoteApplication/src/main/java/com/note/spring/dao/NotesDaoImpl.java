package com.note.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.note.spring.model.Notes;




public class NotesDaoImpl implements NotesDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Notes notes) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(notes);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Notes getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Notes notes = (Notes) session.get(Notes.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return notes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notes> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Notes> noteList = session.createCriteria(Notes.class)
				.list();
		tx.commit();
		session.close();
		return noteList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.get(Notes.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
