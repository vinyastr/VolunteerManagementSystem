package Business.SignUp;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import javax.swing.JPanel;
import userinterface.SignUp.SignUpJPanelEnterprise;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinya
 */
public class SignUpRequestEnterprise extends SignUpRequest{

   private CountryNetwork Country;
    private StateNetwork State;
    private EnterpriseType enterprise;
    
    public SignUpRequestEnterprise(){
        super();
    }

    public EnterpriseType getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(EnterpriseType enterprise) {
        this.enterprise = enterprise;
    }
    
    

       
    public CountryNetwork getCountry() {
        return Country;
    }

    public void setCountry(CountryNetwork Country) {
        this.Country = Country;
    }

    public StateNetwork getState() {
        return State;
    }

    public void setState(StateNetwork State) {
        this.State = State;
    }
 
    
    @Override
    public JPanel signUpForm(JPanel userProcessContainer, EcoSystem business) {
        return new SignUpJPanelEnterprise(userProcessContainer,business);
    }
    
    
}
