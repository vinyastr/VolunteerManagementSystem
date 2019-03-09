/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.EcoSystem;
import Business.Employee.EmployeeDirectory;
import Business.Event.EventDirectory;
import Business.LatLong;
import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.HashSet;


public abstract class Organization {
private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    public HashSet<Role> roles;
    private PersonDirectory personList;
    private String city;
    private EventDirectory eventDirectory;
    private int temp;
    private LatLong latLong;
    
//    private EcoSystem system= EcoSystem.getInstance();
    public enum Type{
        OldAge("Oldage Home Organization"),Orphanage("Orphanage Organization"),Homeless("Homeless Shelter Organization"), Disaster("Disaster Recovery Organization"),Hospital("Hospital Organization"),Education("Education Organization"),NGO("NGO Organization"),MNC("MNC Organization"),Individuals("Individuals Organization"),Transportation("Transportation Organization"),BGV("BGV Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
       public enum RequestType{
        Education("Education Institution"),Hospital("Hospital"),MNC("MNC"),NGO("NGO"),ANY("ANY");
         
        private String value;
        private RequestType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    } 

   public Organization(String name, String city, LatLong address) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
//       
//         if(counter==0){
//            counter= EcoSystem.getInstance().orgCount;
//        }
        organizationID = ++counter;
   //    EcoSystem.getInstance().orgCount = counter;
        roles = new HashSet<>();
        personList= new PersonDirectory();
        eventDirectory= new EventDirectory();
        this.city=city;
        latLong=address;
        
    }

    public abstract HashSet<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PersonDirectory getPersonList() {
        return personList;
    }

    public void setPersonList(PersonDirectory personList) {
        this.personList = personList;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public LatLong getLatLong() {
        return latLong;
    }

    public void setLatLong(LatLong latLong) {
        this.latLong = latLong;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public EventDirectory getEventDirectory() {
        return eventDirectory;
    }

    public void setEventDirectory(EventDirectory eventDirectory) {
        this.eventDirectory = eventDirectory;
    }
    
       public double populateDistance(LatLong p1) {
        double lat1= p1.getLatitude();
        double lon1=p1.getLongitude();
        double lat2=latLong.getLatitude();
        double lon2=latLong.getLongitude();
  double theta = lon1 - lon2;
  double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
  dist = Math.acos(dist);
  dist = rad2deg(dist);
  dist = dist * 60 * 1.1515;
  return dist;
    }
    private double deg2rad(double deg) {
  return (deg * Math.PI / 180.0);
}
    private double rad2deg(double rad) {
  return (rad * 180.0 / Math.PI);
}
    
    @Override
    public String toString() {
        return name;
    }    
}
