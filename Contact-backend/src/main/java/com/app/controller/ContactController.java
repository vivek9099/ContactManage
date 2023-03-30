package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Contact;
import com.app.service.ContactService;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}
	
	//create contact RESTAPI
	@PostMapping()
	public ResponseEntity<Contact> saveContact(@RequestBody Contact contact){
		return new ResponseEntity<Contact>(contactService.saveContact(contact),HttpStatus.OK);
		
	}
	
	//build to get all contacts
	@GetMapping
	public List<Contact> getAllContacts(){
		return contactService.getAllContacts();
	}
	
	//Build get contacts by ID
	//http://localhost:8080/api/contacts
	@GetMapping("{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable("id")long contactId){
		return new ResponseEntity<Contact>(contactService.getContactById(contactId),HttpStatus.OK);
		
		
	}
	
	//update contact
	//http://localhost:8080/api/contacts/1
	@PutMapping("{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable("id")long id
			                                       ,@RequestBody Contact contact){
		return new ResponseEntity<Contact>(contactService.updateContact(contact, id),HttpStatus.OK);
		
		
	}
	
	//Delete contact 
	//http://localhost:8080/api/contacts/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteContact(@PathVariable("id")long id){
		contactService.deleteContact(id);
		
		return new ResponseEntity<String>("Contact Deleted Suuceesfully",HttpStatus.OK);
		
	}

}
