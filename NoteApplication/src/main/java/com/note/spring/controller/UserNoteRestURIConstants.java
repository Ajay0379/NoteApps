package com.note.spring.controller;

public class UserNoteRestURIConstants {

	public static final String DUMMY_USER = "/rest/usr/dummy";
	public static final String GET_USER = "/rest/use/{id}";
	
	public static final String UPDATE_USER = "/rest/usr/update/{id}";
	public static final String UPDATE_NOTE = "/rest/note/update/{id}";
	
	public static final String GET_ALL_USER = "/rest/users";
	public static final String CREATE_USER = "/rest/usr/create";
	public static final String DELETE_USER = "/rest/usr/delete/{id}";
	
	
	public static final String GET_NOTE = "/rest/note/{id}";
	public static final String GET_ALL_NOTES = "/rest/notes";
	public static final String CREATE_NOTE = "/rest/note/create";
	public static final String DELETE_NOTE = "/rest/note/delete/{id}";
}
