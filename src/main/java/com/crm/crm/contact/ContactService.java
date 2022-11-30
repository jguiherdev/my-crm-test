package com.crm.crm.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(String id) {
        return contactRepository.findById(Long.valueOf(id)).get();
    }

    public void deleteContactById(String id) {
         contactRepository.deleteById(Long.valueOf(id));
    }

    public Contact update(String id,Contact contact) {
        Contact contactToUpdate = contactRepository.findById(Long.valueOf(id)).get();
        contactToUpdate.setVia(contact.getVia());
        contactToUpdate.setDate(contact.getDate());
        contactToUpdate.setDescription(contact.getDescription());
        contactRepository.save(contactToUpdate);
        return contactToUpdate;
        
    }
  
}
