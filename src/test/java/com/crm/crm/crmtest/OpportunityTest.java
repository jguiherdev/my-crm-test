package com.crm.crm.crmtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.crm.crm.opportunity.Opportunity;
import com.crm.crm.opportunity.OpportunityRepository;
import com.crm.crm.opportunity.OpportunityService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OpportunityTest {

    @InjectMocks
    OpportunityService opportunityService;

    @Mock
    OpportunityRepository opportunityRepository;

    @Test
    public void updateOpportunityTest(){
        Opportunity opportunity=new Opportunity();
        opportunity.setId(1L);
        opportunity.setName("test");
        opportunity.setDescription("test");
        opportunity.setIsClient(true);
        opportunity.setEmail(""); 
        opportunity.setPhone("123456789");
        Mockito.when(opportunityRepository.findById(1L)).thenReturn(java.util.Optional.of(opportunity));
        opportunityService.updateOpportunity("1", opportunity);
        assertEquals("test", opportunityService.getOpportunityById("1").getName());
    }

    @Test
    public void getContactsByOpportunityIdTest(){
        Opportunity opportunity=new Opportunity();
        opportunity.setId(1L);
        opportunity.setName("test");
        opportunity.setDescription("test");
        opportunity.setIsClient(false);
        opportunity.setEmail(""); 
        opportunity.setPhone("123456789");
        List<Contact> contacts = new ArrayList<>();
        Contact contact = new Contact();
        Contact contact2 = new Contact();
        contact.setId(1L);
        contacts.add(contact);
        contact2.setId(2L);
        contacts.add(contact2);
        opportunity.setContacts(contacts);
        Mockito.when(opportunityRepository.findById(1L)).thenReturn(java.util.Optional.of(opportunity));
        List<Contact> contactsFromOpportunity = opportunityService.getContactsByOpportunityId("1");
        assertEquals(2, contactsFromOpportunity.size());
        
    }

    

}
