/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Role.BGVAdmin;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author raunak
 */
public class GovernmentEnterprise extends Enterprise{

    public GovernmentEnterprise(String name) {
        super(name, EnterpriseType.Government);
    }
    
    @Override
    public ArrayList<Type> getOrganizations() {
        ArrayList<Type> orgs = new ArrayList<>();
        orgs.add(Organization.Type.BGV);
        return orgs;
    }
    @Override
    public HashSet<Role> getSupportedRole() {
         roles= new HashSet<>();
        roles.add(new BGVAdmin());
        return roles;
    }
    
    
    
}
