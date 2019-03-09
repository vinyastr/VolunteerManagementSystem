package Business.SignUp;

import Business.EcoSystem;
import javax.swing.JPanel;
import userinterface.SignUp.SignUpJPanelCountry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinya
 */
public class SignUpRequestCountry extends SignUpRequest{

        public SignUpRequestCountry(){
        super();
    }
    
    @Override
    public JPanel signUpForm(JPanel userProcessContainer, EcoSystem business) {
        return new SignUpJPanelCountry(userProcessContainer,business);
    }
    
 
    
}
