package com.crm.crm.crmtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.crm.crm.contact.Contact;
import com.crm.crm.contact.ContactRepository;
import com.crm.crm.contact.ContactService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ContactTest {

    
    @InjectMocks
    ContactService contactService;

    @Mock
    ContactRepository contactRepository;

    //test for method getAllContacts
    @Test
    public void testGetAllContacts() {
        List<Contact> listMock = new ArrayList<>(
        );
        listMock.add(new Contact());
        listMock.add(new Contact());
        Mockito.when(contactRepository.findAll()).thenReturn(listMock);
        contactService.getAllContacts();
        assertEquals(2, contactService.getAllContacts().size());
        
    }

    @Test
    public void testUpdateContact() {

        LocalDateTime localDateTime = LocalDateTime.now();
        
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setVia("email");
        contact.setDate(localDateTime);
        contact.setDescription("test");
        Mockito.when(contactRepository.findById(1L)).thenReturn(java.util.Optional.of(contact));
        contactService.update("1", contact);
        assertEquals("email", contactService.getContactById("1").getVia());
        
    }

}
