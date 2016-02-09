package com.note.spring.services;

import java.util.List;

import com.note.spring.model.Notes;





public interface NoteServices {
	public boolean addEntity(Notes employee) throws Exception;
	public Notes getEntityById(long id) throws Exception;
	public List<Notes> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
