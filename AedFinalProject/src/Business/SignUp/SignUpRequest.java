/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SignUp;

import Business.EcoSystem;
import Business.WorkQueue.WorkRequest;
import java.awt.image.BufferedImage;
import java.util.Date;
import javax.swing.JPanel;

/**
 *
 * @author vinya
 */
public abstract class SignUpRequest extends WorkRequest{
    
    private String name;
    private String userName;
    private String password;
    private BufferedImage image;
    private Date requestDate;
    private String email;
    private String phone;
    
    public SignUpRequest(){
        requestDate=new Date();
    }
    
    public enum SignUpType{
        
        
        Organization("Organization"),
        Country("Country"),
        Enterprise("Enterprise"),
        State("State");
        
        private String value;

        private SignUpType(String value) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
        public abstract JPanel signUpForm(JPanel userProcessContainer,EcoSystem business);
}
