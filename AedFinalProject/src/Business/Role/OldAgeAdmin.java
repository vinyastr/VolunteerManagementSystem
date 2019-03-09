/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Organization.MNCOrganization;
import Business.Organization.OldAgeOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;
import userinterface.Beneficiary.OlgAgeHome.OldAgeHomeAdminWorkAreaJPanel;
import userinterface.EntityAdmin.MNCAdmin.MNCAdminWorkAreaJPanel;


/**
 *
 * @author raunak
 */
public class OldAgeAdmin extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, StateNetwork network,CountryNetwork cNetwork, EcoSystem business) {
        return new OldAgeHomeAdminWorkAreaJPanel(userProcessContainer,account,(OldAgeOrganization)organization,enterprise,network,cNetwork,business);
    }
    
    @Override
    public String toString(){
        return RoleType.OldAgeAdmin.getValue();
    }

   
}
