/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.LatLong;
import Business.Role.DisasterAdmin;
import Business.Role.EducationAdmin;
import Business.Role.Role;
import java.util.HashSet;


public class EducationOrganization extends  Organization{
    private String name;
    public EducationOrganization(String name, String city,LatLong address) {
        super(name,city, address);
        this.name=name;
    }

     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public HashSet<Role> getSupportedRole() {
     roles= new HashSet<>();
        roles.add(new EducationAdmin()); 
        return roles;
    }

}
