package com.crm.crm.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping(path="/add")
    public void saveContact (@RequestBody Contact contact) {
        contactService.save(contact);
    }



   



    
    
}
