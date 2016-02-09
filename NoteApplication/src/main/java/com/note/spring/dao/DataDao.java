package com.note.spring.dao;

import java.util.List;

import com.note.spring.model.User;



public interface DataDao {

	public boolean addEntity(User usr) throws Exception;
	public User getEntityById(long id) throws Exception;
	public List<User> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
