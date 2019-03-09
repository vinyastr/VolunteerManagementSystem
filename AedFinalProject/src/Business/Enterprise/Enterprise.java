/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;


/**
 *
 * @author raunak
 */
public abstract class Enterprise extends Organization{

    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    
    public Enterprise(String name, EnterpriseType type) {
        super(name, null,null);
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }
 
    public enum EnterpriseType{
        Beneficiary("Beneficiary"), Entity("Entity"), Government("Government"), Logistic("Logistic") ;
        
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract ArrayList<Type> getOrganizations();
    
    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

}
