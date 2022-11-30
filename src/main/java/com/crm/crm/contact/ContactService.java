package com.crm.crm.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    public Iterable<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).get();
    }


    
}
