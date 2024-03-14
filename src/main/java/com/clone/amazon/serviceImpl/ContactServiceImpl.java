package com.clone.amazon.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.amazon.collections.Contact;
import com.clone.amazon.repositories.ContactRepository;
import com.clone.amazon.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public String saveContact(Contact contact) {
		Contact addedContact = contactRepository.save(contact);
		if(addedContact!=null) {
			return "added successfully";
		}
		return "error";
	}

}
