/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.TransportationAdmin;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Administrator
 */
public class LogisticEnterprise extends Enterprise{
      public LogisticEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Logistic);
    }
      
     @Override
     public ArrayList<Type> getOrganizations() {
        ArrayList<Type> orgs = new ArrayList<>();
        orgs.add(Organization.Type.Transportation);
        return orgs;
    }
    @Override
    public HashSet<Role> getSupportedRole() {
         roles= new HashSet<>();
        roles.add(new TransportationAdmin());
        return roles;
    }
}
