/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.LogisticEnterprise;
import Business.LatLong;
import Business.Organization.Organization.Type;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type, String name, String city, LatLong address){
        Organization organization = null;
        if (type.getValue().equals(Type.OldAge.getValue())){
            organization = new OldAgeOrganization(name,city,address);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Orphanage.getValue())){
            organization = new OrphanageOrganization(name,city,address);
            organizationList.add(organization);
        }
       
        else if (type.getValue().equals(Type.Homeless.getValue())){
            organization = new HomelessOrganization(name,city,address);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Disaster.getValue())){
            organization = new DisasterOrganization(name,city,address);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Hospital.getValue())){
            organization = new HospitalOrganization(name,city,address);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Education.getValue())){
            organization = new EducationOrganization(name,city,address);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.NGO.getValue())){
            organization = new NGOOrganization(name,city,address);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.MNC.getValue())){
            organization = new MNCOrganization(name,city,address);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Individuals.getValue())){
            organization = new IndividualOrganization(name,city,address);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Transportation.getValue())){
            organization = new TransportOrganization(name,city,address);
            organizationList.add(organization);
        }
        
        else if (type.getValue().equals(Type.BGV.getValue())){
            organization = new BGVOrganization(name,city,address);
            organizationList.add(organization);
        }
 
        return organization;
    }
}