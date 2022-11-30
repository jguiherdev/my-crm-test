package com.crm.crm.opportunity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.crm.contact.Contact;

@Controller
@RequestMapping(path="/opportunities")
public class OpportunityController {

    @Autowired 
    
    OpportunityService opportunityService;


    @PostMapping(path="/add")
    public ResponseEntity<Opportunity> saveOpportunity (@RequestBody Opportunity opportunity) {
        opportunityService.saveOpportunity(opportunity);
        return new ResponseEntity<Opportunity>(opportunity, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Opportunity> getContactById(@PathVariable("id") String id) {
        return new ResponseEntity<Opportunity>(opportunityService.getOpportunityById(id), HttpStatus.OK);
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Opportunity> getAllOpportunities() {
        return opportunityService.getAllOpportunities();
    }

    @PutMapping(path="/update/{id}")
    public ResponseEntity<Opportunity> updateOpportunity (@PathVariable("id") String id, @RequestBody Opportunity opportunity) {
        return new ResponseEntity<Opportunity>(opportunityService.updateOpportunity(id,opportunity), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}")
    public ResponseEntity<Opportunity> deleteOpportunityById(@PathVariable("id") String id) {
        opportunityService.deleteOpportunityById(id);
        return new ResponseEntity<Opportunity>(HttpStatus.NO_CONTENT);
    }

  
    
}
