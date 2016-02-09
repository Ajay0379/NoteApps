package com.note.spring.services;

import java.util.List;

import com.note.spring.model.User;



public interface DataServices {
	public boolean addEntity(User employee) throws Exception;
	public User getEntityById(long id) throws Exception;
	public List<User> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
