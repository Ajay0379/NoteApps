package com.note.spring.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.note.spring.model.User;
import com.note.spring.services.DataServices;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//Map to store employees, ideally we should use database
	Map<Integer, User> empData = new HashMap<Integer, User>();
	@Autowired
	DataServices dataServices;
	
	@RequestMapping(value = UserNoteRestURIConstants.UPDATE_USER, method = RequestMethod.POST)
    public ResponseBody intupdateUser(@PathVariable("id") long id, @RequestBody User user) throws Exception {
        System.out.println("Updating User " + id);
         
        User currentUser = dataServices.getEntityById(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
        }
 
        currentUser.setCreateTime(new Date());
        currentUser.setEmail(user.getEmail());
        currentUser.setPassword(user.getPassword());
        currentUser.setLastUpdateTime(new Date());
        dataServices.addEntity(currentUser);
        return (ResponseBody) new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
	
	@RequestMapping(value = UserNoteRestURIConstants.GET_USER, method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable("id") int usrId) throws Exception {
		logger.info("Start userID="+usrId);
		User usr=dataServices.getEntityById(usrId);
		return usr;
	}
	
	@RequestMapping(value = UserNoteRestURIConstants.GET_ALL_USER, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUser() throws Exception {
		logger.info("Start getAllUser.");
		List<User> empIdKeys=dataServices.getEntityList();
		return empIdKeys;
	}
	
	@RequestMapping(value = UserNoteRestURIConstants.CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User usr) {
		logger.info("Start createEmployee.");
		try {
			dataServices.addEntity(usr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usr;
	}
	
	@RequestMapping(value = UserNoteRestURIConstants.DELETE_USER, method = RequestMethod.POST)
	public @ResponseBody boolean deleteUser(@PathVariable("id") long userId) throws Exception {
		logger.info("Start deleteEmployee.");
		return dataServices.deleteEntity(userId);
	}
	
}
