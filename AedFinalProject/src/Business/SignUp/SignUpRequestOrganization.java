package Business.SignUp;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.LatLong;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import javax.swing.JPanel;
import userinterface.SignUp.SignUpJPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinya
 */
public class SignUpRequestOrganization extends SignUpRequest{

   private CountryNetwork Country;
    private StateNetwork State;
    private Enterprise enterprise;
    private Organization.Type orgType;
    private String city;
    private String orgName;
    private String address;
    private LatLong latLong;
    public SignUpRequestOrganization(){
        super();
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Organization.Type getOrgType() {
        return orgType;
    }

    public void setOrgType(Organization.Type orgType) {
        this.orgType = orgType;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LatLong getLatLong() {
        return latLong;
    }

    public void setLatLong(LatLong latLong) {
        this.latLong = latLong;
    }
 
    
    
    @Override
    public JPanel signUpForm(JPanel userProcessContainer, EcoSystem business) {
        return new SignUpJPanel(userProcessContainer,business,SignUpType.Organization);
    }
    
    
}
