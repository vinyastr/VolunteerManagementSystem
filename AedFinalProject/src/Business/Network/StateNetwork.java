/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class StateNetwork{
    
    private String name;
    private EnterpriseDirectory enterpriseDirectory;

    public StateNetwork() {
       
        enterpriseDirectory = new EnterpriseDirectory();
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
    

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

   
}
