package Business.SignUp;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.CountryNetwork;
import javax.swing.JPanel;
import userinterface.SignUp.SignUpJPanelState;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinya
 */
public class SignUpRequestState extends SignUpRequest{
    
    private CountryNetwork Country;
  
    
    public SignUpRequestState(){
    super();
    }

    public CountryNetwork getCountry() {
        return Country;
    }

    public void setCountry(CountryNetwork Country) {
        this.Country = Country;
    }
    
    @Override
    public JPanel signUpForm(JPanel userProcessContainer, EcoSystem business) {
        return new SignUpJPanelState(userProcessContainer,business);
    }
 
//    @Override
//    public String toString(){
//    return SignUpRequest.SignUpType.State.getValue();
//    }
    
}
