/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Organization.IndividualOrganization;
import Business.Organization.OldAgeOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;
import userinterface.Beneficiary.OlgAgeHome.OldAgeHomeAdminWorkAreaJPanel;
import userinterface.EntityAdmin.Individuals.IndividualAdminWorkAreaJPanel;
import userinterface.EntityAdmin.Individuals.IndividualRequestAreaJPanel;


/**
 *
 * @author raunak
 */
public class IndividualAdmin extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, StateNetwork network,CountryNetwork cNetwork, EcoSystem business) {
        return new IndividualAdminWorkAreaJPanel(userProcessContainer,account,(IndividualOrganization)organization,enterprise,network,cNetwork,business);
    }
    
    @Override
    public String toString(){
        return RoleType.IndividualAdmin.getValue();
    }

   
}
