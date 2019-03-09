/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Organization.HospitalOrganization;
import Business.Organization.NGOOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;
import userinterface.EntityAdmin.Hospital.HospitalAdminWorkAreaJPanel;
import userinterface.EntityAdmin.NGO.NGOAdminWorkAreaJPanel;


/**
 *
 * @author raunak
 */
public class NGOAdmin extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, StateNetwork network,CountryNetwork cNetwork, EcoSystem business) {
        return new NGOAdminWorkAreaJPanel(userProcessContainer,account,(NGOOrganization)organization,enterprise,network,cNetwork,business);
    }
    
    @Override
    public String toString(){
        return RoleType.NGOAdmin.getValue();
    }

   
}
