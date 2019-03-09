/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Organization.TransportOrganization;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;
import userinterface.Logistics.LogisticsAdminWorkAreaJPanel;
import userinterface.Logistics.Transportation.TransportationAdminWorkAreaJPanel;


/**
 *
 * @author raunak
 */
public class TransportationAdmin extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, StateNetwork network,CountryNetwork cNetwork, EcoSystem business) {
        return new TransportationAdminWorkAreaJPanel(userProcessContainer,account,(TransportOrganization) organization,enterprise,network,cNetwork,business);
    }
    
    @Override
    public String toString(){
        return RoleType.TransportationAdmin.getValue();
    }

   
}
