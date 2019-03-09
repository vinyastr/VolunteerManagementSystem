/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;

import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Beneficiary.BeneficiaryAdminWorkAreaJPanel;

import userinterface.EntityAdmin.EntityAdminWorkAreaJPanel;


/**
 *
 * @author Administrator
 */
public class BeneficiaryAdminRole extends Role{
  
   

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, StateNetwork network, CountryNetwork cNetwork, EcoSystem business) {
       return new BeneficiaryAdminWorkAreaJPanel(userProcessContainer,account,enterprise,network,cNetwork,business);
       
    }
      @Override
    public String toString(){
        return RoleType.BeneficiaryAdmin.getValue();
    }
}
