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

    public Opportunity getOpportunityById(String id) {
        return opportunityRepository.findById(Long.valueOf(id)).get();
    }

    public void deleteOpportunityById(String id) {
        opportunityRepository.deleteById(Long.valueOf(id));
    }

    public Opportunity updateOpportunity(String id, Opportunity opportunity) {
        Opportunity opportunityToUpdate = opportunityRepository.findById(Long.valueOf(id)).get();
        opportunityToUpdate.setName(opportunity.getName());
        opportunityToUpdate.setDescription(opportunity.getDescription());
        opportunityToUpdate.setIsClient(opportunity.getIsClient());
        opportunityToUpdate.setEmail(opportunity.getEmail());
        opportunityToUpdate.setPhone(opportunity.getPhone());
        opportunityRepository.save(opportunityToUpdate);
        return opportunityToUpdate;
    }
    
  
}
