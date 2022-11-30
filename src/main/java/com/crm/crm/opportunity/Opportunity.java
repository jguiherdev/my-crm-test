package com.crm.crm.opportunity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.crm.crm.contact.Contact;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "OPPORTUNITIES")
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OPPORTUNITY_ID")
    private Long id;

    @Column(name = "OPPORTUNITY_NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "OPPORTUNITY_DESCRIPTION", nullable = false, length = 50)
    private String description;

    @Column(name = "OPPORTUNITY_ISCLIENT", nullable = false, columnDefinition = "Boolean default false")
    private Boolean isClient;

    @Column(name = "OPPORTUNITY_EMAIL", nullable = false, length = 50)
    private String email;

    @Column(name = "OPPORTUNITY_PHONE", nullable = false, length = 50)
    private String phone;

    @Column(name = "CONVERSION_DATE", nullable = true)
    private LocalDateTime conversionDate;

    @ManyToOne
    @JoinColumn(name = "PARENT_OPPORTUNITY", nullable = true)
    @JsonBackReference
    private Opportunity opportunity;

    @OneToMany(mappedBy = "opportunity")
    @JsonIgnore
    private List<Contact> contacts = new ArrayList<>();

    public Opportunity(Long id, String name, String description, Boolean isClient, String email, String phone,
            LocalDateTime conversionDate, Opportunity opportunity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isClient = isClient;
        this.email = email;
        this.phone = phone;
        this.conversionDate = conversionDate;
        this.opportunity = opportunity;
        
    }

    public Opportunity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsClient() {
        return isClient;
    }

    public void setIsClient(Boolean isClient) {
        this.isClient = isClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getConversionDate() {
        return conversionDate;
    }

    public void setConversionDate(LocalDateTime conversionDate) {
        this.conversionDate = conversionDate;
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    


    
    
    
    

    
    
}
