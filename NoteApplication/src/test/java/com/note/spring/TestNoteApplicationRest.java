package com.note.spring;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.note.spring.controller.UserNoteRestURIConstants;
import com.note.spring.model.Notes;
import com.note.spring.model.User;

public class TestNoteApplicationRest {

	public static final String SERVER_URI = "http://localhost:9090/SpringRestExample";
	
	public static void main(String args[]){
		
		
		testCreateUser();
		testGetUser();
		testGetAllUser();
		testGetAllNotes();
	    testDeleteUser();
		testNotes();
		testDeleteNotes();
		testUpdateUser();
		testUpdateNotes();
	}

	private static void testGetAllUser() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> usr = restTemplate.getForObject(SERVER_URI+UserNoteRestURIConstants.GET_ALL_USER, List.class);
		System.out.println(usr.size());
		for(LinkedHashMap map : usr){
			System.out.println("ID="+map.get("id")+",Name="+map.get("password")+",CreatedDate="+map.get("createdDate"));;
		}
	}
	
	private static void testGetAllNotes() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> notes = restTemplate.getForObject(SERVER_URI+UserNoteRestURIConstants.GET_ALL_NOTES, List.class);
		System.out.println(notes.size());
		for(LinkedHashMap map : notes){
			System.out.println("ID="+map.get("id")+",Name="+map.get("password")+",CreatedDate="+map.get("createdDate"));;
		}
	}

	private static void testCreateUser() {
		RestTemplate restTemplate = new RestTemplate();
		
		
		String requestJson = "{\"email\":\"aja345223y@abc.com\",\"password\":\"vijay11\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		

		HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
		String answer = restTemplate.postForObject(SERVER_URI+UserNoteRestURIConstants.CREATE_USER, entity, String.class);
		System.out.println(answer);
		int beginIndex=answer.indexOf("userId");
		int endIndex=answer.indexOf(",");
	
		
		String requestNotesJson = "{\"id\":\""+answer.substring(beginIndex+8, endIndex)+"\",\"title\":\"Notes\",\"noteDescription\":\"ajay hello12\"}";
		HttpHeaders notesheaders = new HttpHeaders();
		notesheaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> notesEntity = new HttpEntity<String>(requestNotesJson,notesheaders);
		String notes = restTemplate.postForObject(SERVER_URI+UserNoteRestURIConstants.CREATE_NOTE, notesEntity, String.class);
		System.out.println(notes);
		
		
	}

	private static void testGetUser() {
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "7");
		User usr = restTemplate.getForObject(SERVER_URI+UserNoteRestURIConstants.GET_USER,  User.class, params);
	}
	
	private static void testNotes() {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "7");
		Notes notes = restTemplate.getForObject(SERVER_URI+UserNoteRestURIConstants.GET_NOTE,  Notes.class, params);
	}

	private static void testDeleteUser() {
		RestTemplate restTemplate = new RestTemplate();
		String id = "10";
		 restTemplate.postForObject(SERVER_URI+UserNoteRestURIConstants.DELETE_USER, User.class, User.class, id);
	}
	private static void testDeleteNotes() {
		RestTemplate restTemplate = new RestTemplate();
		String id = "11";
		restTemplate.postForObject(SERVER_URI+UserNoteRestURIConstants.DELETE_NOTE, Notes.class, Notes.class, id);	
	}

	
	private static void testUpdateUser() {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> vars = new HashMap<String, String>();
	    vars.put("id", "6");
		String requestJson = "{\"email\":\"ajayyadav03@abc.com\",\"password\":\"vij2223ay11\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
		User user = restTemplate.postForObject(SERVER_URI+UserNoteRestURIConstants.UPDATE_USER, entity, User.class, vars);
		
	}
	
	private static void testUpdateNotes() {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> vars = new HashMap<String, String>();
	    vars.put("id", "7");
	    String requestNotesJson = "{\"title\":\"Notesnew\",\"noteDescription\":\"ajay hello\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(requestNotesJson,headers);
		Notes notes = restTemplate.postForObject(SERVER_URI+UserNoteRestURIConstants.UPDATE_NOTE, entity, Notes.class, vars);
		
	}
	
	
}
