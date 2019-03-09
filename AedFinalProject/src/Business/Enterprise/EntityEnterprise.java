/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Role.EducationAdmin;
import Business.Role.HospitalAdmin;
import Business.Role.IndividualAdmin;
import Business.Role.MNCAdmin;
import Business.Role.NGOAdmin;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Administrator
 */
public class EntityEnterprise extends Enterprise {

    public EntityEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Entity);
    }
    
    @Override
    public ArrayList<Type> getOrganizations() {
        ArrayList<Type> orgs = new ArrayList<>();
        orgs.add(Organization.Type.Hospital);
        orgs.add(Organization.Type.Education);
        orgs.add(Organization.Type.Individuals);
        orgs.add(Type.NGO);
        orgs.add(Type.MNC);
        return orgs;
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles = new HashSet<>();
        roles.add(new EducationAdmin());
        roles.add(new MNCAdmin());
        roles.add(new NGOAdmin());
        roles.add(new IndividualAdmin());
        roles.add(new HospitalAdmin());

//        roles.add(new SupplierRole());
        return roles;
    }

}
