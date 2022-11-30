package com.crm.crm.crmtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

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

    //test for update opportunity method
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

}
