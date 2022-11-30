package com.crm.crm.contact;

import java.time.LocalDateTime;

import com.crm.crm.opportunity.Opportunity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTACTS")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONTACT_ID")
    public Long id;

    @Column(name = "CONTACT_VIA", nullable = false, length = 50)
    public String via;
    
    @ManyToOne
    @JoinColumn(name = "OPPORTUNITY_ID")
    public Opportunity opportunity;

    @Column(name = "CONTACT_DATE", nullable = false, length = 50)
    public LocalDateTime date;

    @Column(name = "CONTACT_DESCRIPTION", nullable = false, length = 50)
    public String description;
    

    public Contact() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getVia() {
        return via;
    }


    public void setVia(String via) {
        this.via = via;
    }


    public Opportunity getOpportunity() {
        return opportunity;
    }


    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }


    public LocalDateTime getDate() {
        return date;
    }


    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    


    
  
    
}
