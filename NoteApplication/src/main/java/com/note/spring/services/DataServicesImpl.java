package com.note.spring.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.note.spring.dao.DataDao;
import com.note.spring.model.User;
import com.note.spring.util.PasswordEncyrptDecryptUtil;



public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
	@Override
	public boolean addEntity(User employee) throws Exception {
		employee.setPassword(PasswordEncyrptDecryptUtil.getEncodedPassword(employee.getPassword()));
		employee.setCreateTime(new Date());
		employee.setLastUpdateTime(new Date());
		
		return dataDao.addEntity(employee);
	}	

	@Override
	public User getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<User> getEntityList() throws Exception {
		List<User> usrListFromDB=dataDao.getEntityList();
		List<User> usrList=new ArrayList<User>();
		for (Iterator<User> iterator = usrListFromDB.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			user.setPassword(PasswordEncyrptDecryptUtil.getDecodedPassword(user.getPassword()));
			usrList.add(user);
			
		}
		return usrList;
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

}
