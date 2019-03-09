/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Event.EventDirectory;
import Business.Organization.Organization;
import Business.Organization.Organization.RequestType;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class BeneficiaryWorkRequest extends WorkRequest{
    private int numberOfVolunteersRequest;
    private Organization senderOrganization;
    private  Date eventDate;
    private boolean add;
    private String eventName;
    private String eventDetails;
    private RequestType requestType;
    private EventDirectory eventDirectory;
    private String email;
    private String logistics;
    private String typeOfVehicle;
    private int noOfVehicle;
    private boolean logisticRequest;
    private Date pickupTime;
    private String address;
    public BeneficiaryWorkRequest(){
        add = false;
        eventDirectory=new EventDirectory();
          logisticRequest= true;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Organization getSenderOrganization() {
        return senderOrganization;
    }

    public void setSenderOrganization(Organization senderOrganization) {
        this.senderOrganization = senderOrganization;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   

    public EventDirectory getEventDirectory() {
        return eventDirectory;
    }

    public void setEventDirectory(EventDirectory eventDirectory) {
        this.eventDirectory = eventDirectory;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public int getNoOfVehicle() {
        return noOfVehicle;
    }

    public void setNoOfVehicle(int noOfVehicle) {
        this.noOfVehicle = noOfVehicle;
    }

    public boolean isLogisticRequest() {
        return logisticRequest;
    }

    public void setLogisticRequest(boolean logisticRequest) {
        this.logisticRequest = logisticRequest;
    }

    public int getNumberOfVolunteersRequest() {
        return numberOfVolunteersRequest;
    }

    public void setNumberOfVolunteersRequest(int numberOfVolunteersRequest) {
        this.numberOfVolunteersRequest = numberOfVolunteersRequest;
    }
    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

   
}
