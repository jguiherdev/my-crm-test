package com.crm.crm.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping(path="/all")
    public ResponseEntity<List<Contact>> getAllContacts() {
        return new ResponseEntity<List<Contact>>(contactService.getAllContacts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") String id) {
        return new ResponseEntity<Contact>(contactService.getContactById(id), HttpStatus.OK);
    }
	
    @PostMapping(path="/add")
    public ResponseEntity<Contact> saveContact (@RequestBody Contact contact) {
        return new ResponseEntity<Contact>(contactService.save(contact), HttpStatus.CREATED);
        
    }

    @PutMapping(path="/update/{id}")
    public ResponseEntity<Contact> updateContact (@PathVariable("id") String id, @RequestBody Contact contact) {
        return new ResponseEntity<Contact>(contactService.update(id,contact), HttpStatus.OK);
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<String> deleteContactById(@PathVariable("id") String id) {
        contactService.deleteContactById(id);
        return new ResponseEntity<String>("Contact deleted successfully", HttpStatus.NO_CONTENT);
    }

}
