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

import com.note.spring.model.Notes;
import com.note.spring.model.User;
import com.note.spring.services.DataServices;
import com.note.spring.services.NoteServices;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class NotesController {

	private static final Logger logger = LoggerFactory.getLogger(NotesController.class);

	Map<Integer, Notes> empData = new HashMap<Integer, Notes>();
	@Autowired
	NoteServices noteServices;
	@Autowired
	DataServices dataServices;

	@RequestMapping(value = UserNoteRestURIConstants.GET_NOTE, method = RequestMethod.GET)
	public @ResponseBody Notes getNote(@PathVariable("id") int noteId) throws Exception {
		logger.info("Start NotesID=" + noteId);
		Notes note = noteServices.getEntityById(noteId);
		return note;
	}

	@RequestMapping(value = UserNoteRestURIConstants.GET_ALL_NOTES, method = RequestMethod.GET)
	public @ResponseBody List<Notes> getAllNotes() throws Exception {
		logger.info("Start getAllNotes.");
		List<Notes> notesIdKeys = noteServices.getEntityList();
		return notesIdKeys;
	}

	@RequestMapping(value = UserNoteRestURIConstants.CREATE_NOTE, method = RequestMethod.POST)
	public @ResponseBody Notes createNotes(@RequestBody Notes note) {
		logger.info("Start createNotes.");
		try {
			User user = dataServices.getEntityById(note.getId());
			note.setUser(user);
			note.setCreateTime(new Date());
			note.setLastUpdateTime(new Date());
			noteServices.addEntity(note);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return note;
	}

	@RequestMapping(value = UserNoteRestURIConstants.UPDATE_NOTE, method = RequestMethod.POST)
	public ResponseBody intupdateNotes(@PathVariable("id") long id, @RequestBody Notes note) throws Exception {
		System.out.println("Updating User " + id);
		Notes currentNote = noteServices.getEntityById(id);
		if (currentNote == null) {
			System.out.println("User with id " + id + " not found");
		}
		currentNote.setCreateTime(new Date());
		currentNote.setTitle(note.getTitle());
		currentNote.setNoteDescription(note.getNoteDescription());
		currentNote.setLastUpdateTime(new Date());
		noteServices.addEntity(currentNote);
		return (ResponseBody) new ResponseEntity<Notes>(HttpStatus.OK);

	}

	@RequestMapping(value = UserNoteRestURIConstants.DELETE_NOTE, method = RequestMethod.POST)
	public @ResponseBody boolean deleteNotes(@PathVariable("id") int noteId) throws Exception {
		logger.info("Start deleteEmployee.");
		return noteServices.deleteEntity(noteId);
	}

}
