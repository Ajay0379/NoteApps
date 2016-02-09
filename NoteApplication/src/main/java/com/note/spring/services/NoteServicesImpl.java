package com.note.spring.services;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.note.spring.dao.NotesDao;
import com.note.spring.model.Notes;




public class NoteServicesImpl implements NoteServices {

	@Autowired
	NotesDao noteDao;
	
	@Override
	public boolean addEntity(Notes note) throws Exception {
		note.setCreateTime(new Date());
		note.setLastUpdateTime(new Date());
		
		return noteDao.addEntity(note);
	}	

	@Override
	public Notes getEntityById(long id) throws Exception {
		return noteDao.getEntityById(id);
	}

	@Override
	public List<Notes> getEntityList() throws Exception {
		return noteDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return noteDao.deleteEntity(id);
	}

}
