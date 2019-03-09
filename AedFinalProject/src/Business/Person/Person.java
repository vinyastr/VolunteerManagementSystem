/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Person;

import Business.EcoSystem;
import java.util.Date;
import javax.swing.ImageIcon;


public class Person {
    
    private String personId;
    private int age;
    private Date dateOfJoining;
    private String ethnicity;
    private String educationBackground;
    private String name;
    private String sex;
    private String reason;
    private static int pCount;
    private String reasonDescription;
    private ImageIcon phtoto;
    private EcoSystem system= EcoSystem.getInstance();
     public Person(){
        dateOfJoining= new Date();
        
       
       if(pCount==0){
            pCount= system.pCounter;
        }
        personId="PID"+ (++pCount);
       system.pCounter = pCount;
    }
    
    public ImageIcon getPhtoto() {
        return phtoto;
    }

    public void setPhtoto(ImageIcon phtoto) {
        this.phtoto = phtoto;
    }
    

    public String getReasonDescription() {
        return reasonDescription;
    }

    public void setReasonDescription(String reasonDescription) {
        this.reasonDescription = reasonDescription;
    }
    
    
   

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    
    
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static int getpCount() {
        return pCount;
    }

    public static void setpCount(int pCount) {
        Person.pCount = pCount;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    
    @Override
    public String toString(){
    return personId;    
    }

    
}
