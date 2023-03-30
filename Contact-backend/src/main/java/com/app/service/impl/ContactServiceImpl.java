package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.exception.ResourceNotFoundException;
import com.app.model.Contact;
import com.app.repository.ContactRepository;
import com.app.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{
	
	private ContactRepository contactRepository;
	
	
	
	public ContactServiceImpl(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	
    @Override
	public Contact saveContact(Contact contact) {
		
		return contactRepository.save(contact);
	}



	@Override
	public List<Contact> getAllContacts() {
		
		return contactRepository.findAll();
	}



	@Override
	public Contact getContactById(long id) {
		/*
		 * Optional<Contact> contact =contactRepository.findById(id);
		 * if(contact.isPresent()) { return contact.get(); }else { throw new
		 * ResourceNotFoundException("Contact","Id",id); }
		 */
		
		return contactRepository.findById(id).orElseThrow(() ->
		                  new ResourceNotFoundException("Contact","Id",id));
	}



	@Override
	public Contact updateContact(Contact contact, long id) {
		// we need to check employee with given id existing in database or not
		
		Contact existingContact = contactRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Contact","Id",id));
		
		
		existingContact.setFirstName(contact.getFirstName());
		existingContact.setLastName(contact.getLastName());
		existingContact.setEmail(contact.getEmail());
		existingContact.setPhoneNo(contact.getPhoneNo());
		
		//save existing contact to database
		return existingContact;
		
		
	}



	@Override
	public void deleteContact(long id) {
		//check whether contact exists or not
		
		contactRepository.findById(id).orElseThrow(()->
		                                   new ResourceNotFoundException("Contact","Id",id));
		
		contactRepository.deleteById(null);
		
	}

}
