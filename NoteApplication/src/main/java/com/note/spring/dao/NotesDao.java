package com.note.spring.dao;

import java.util.List;

import com.note.spring.model.Notes;




public interface NotesDao {

	public boolean addEntity(Notes notes) throws Exception;
	public Notes getEntityById(long id) throws Exception;
	public List<Notes> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
