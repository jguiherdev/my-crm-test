package com.crm.crm.opportunity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpportunityService {

    @Autowired 
    
    OpportunityRepository opportunityRepository;

    public List<Opportunity> getAllOpportunities() {
        return opportunityRepository.findAll();
    }

    public void saveOpportunity(Opportunity opportunity) {
        opportunityRepository.save(opportunity);
    }

    public Opportunity getOpportunityById(Long id) {
        return opportunityRepository.findById(id).get();
    }
    
}
