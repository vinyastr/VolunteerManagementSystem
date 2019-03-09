package Business;

import Business.Employee.Employee;
import Business.Role.CountryAdminRole;
import Business.Role.EcoSystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Employee employee = system.getEmployeeDirectory().createEmployee("Admin","poojithshtt@gmail.com");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("admin", "admin", employee, new EcoSystemAdminRole());
        
        return system;
    }
    
}
