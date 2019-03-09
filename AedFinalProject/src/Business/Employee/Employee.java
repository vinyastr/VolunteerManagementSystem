/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.EcoSystem;

/**
 *
 * @author raunak
 */
public class Employee {
    
    private String name;
    private String emailId;
    private int id;
    private static int eCount = 0;
    private EcoSystem system= EcoSystem.getInstance();

    public Employee() {
        if(eCount==0){
            eCount= system.employeeCount;
        }
        id = ++eCount;
       system.employeeCount  = eCount;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
