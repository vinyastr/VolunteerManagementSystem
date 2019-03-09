/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Event;

import Business.EcoSystem;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author prashantreddy
 */
public class Event {
    private String eventName;
    private int availVolunteers;
    private Date eventDate;
   private int requiredVolunteers;
    private Organization senderOrganization;
    private Organization servingOrganization;
    private static int evCount=0;
    private String eventId;
 private EcoSystem system= EcoSystem.getInstance();
    public Event() {
         if(evCount==0){
            evCount= system.eventCount;
        }
        eventId= "EventId" +  ++evCount;
       system.eventCount  = evCount;
    }
    
    public String getEventName() {
        return eventName;
        
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getAvailVolunteers() {
        return availVolunteers;
    }

    public void setAvailVolunteers(int availVolunteers) {
        this.availVolunteers = availVolunteers;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public int getRequiredVolunteers() {
        return requiredVolunteers;
    }

    public void setRequiredVolunteers(int requiredVolunteers) {
        this.requiredVolunteers = requiredVolunteers;
    }

    public Organization getSenderOrganization() {
        return senderOrganization;
    }

    public void setSenderOrganization(Organization senderOrganization) {
        this.senderOrganization = senderOrganization;
    }

    public Organization getServingOrganization() {
        return servingOrganization;
    }

    public void setServingOrganization(Organization servingOrganization) {
        this.servingOrganization = servingOrganization;
    }

 

    public String getEventId() {
        return eventId;
    }

    @Override
    public String toString() {
        return this.eventName;
    }
    
    
}
