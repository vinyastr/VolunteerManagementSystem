/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import Business.EcoSystem;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import com.sun.glass.events.KeyEvent;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userinterface.SignUp.SignUpWelcome;
import userinterface.googleApi.DistanceJPanel;
import userinterface.googleApi.HomelessFoundJPanel;

/**
 *
 * @author Administrator
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public static int fail = 0;

    public MainJFrame() {
        initComponents();
        system = dB4OUtil.retrieveSystem();
        EcoSystem.setInstance(system);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        populateCountryCombo();

    }

    public void populateCountryCombo() {
        comboCountry.removeAllItems();;
        for (CountryNetwork countryNetwork : system.getNetworkList()) {
            comboCountry.addItem(countryNetwork);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        loginJButton = new javax.swing.JButton();
        userNameJTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginJLabel = new javax.swing.JLabel();
        logoutJButton = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        btnHomeless = new javax.swing.JButton();
        comboCountry = new javax.swing.JComboBox();
        comboState = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(220);

        jPanel1.setBackground(new java.awt.Color(71, 79, 112));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginJButton.setBackground(new java.awt.Color(255, 255, 255));
        loginJButton.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        loginJButton.setForeground(new java.awt.Color(71, 79, 112));
        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loginJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 100, 40));
        jPanel1.add(userNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 118, -1));

        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });
        jPanel1.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 118, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        jPanel1.add(loginJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        logoutJButton.setBackground(new java.awt.Color(0, 0, 0));
        logoutJButton.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        logoutJButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutJButton.setText("Logout");
        logoutJButton.setEnabled(false);
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logoutJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 100, 40));

        btnSignUp.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(71, 79, 112));
        btnSignUp.setText("Register");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 140, 50));

        btnHomeless.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnHomeless.setForeground(new java.awt.Color(213, 10, 18));
        btnHomeless.setText("Homeless Found");
        btnHomeless.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomelessActionPerformed(evt);
            }
        });
        jPanel1.add(btnHomeless, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 170, 40));

        comboCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCountryActionPerformed(evt);
            }
        });
        jPanel1.add(comboCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 110, -1));

        jPanel1.add(comboState, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 110, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Country");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 60, -1));

        jLabel5.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("State");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 50, -1));

        jSplitPane1.setLeftComponent(jPanel1);

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setLayout(new java.awt.CardLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/global-world-map-background-business-template-d-globe-40201747.jpg"))); // NOI18N
        container.add(jLabel6, "card2");

        jSplitPane1.setRightComponent(container);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        // Get user name

        String userName = userNameJTextField.getText();
        // Get Password
        char[] passwordCharArray = passwordField.getPassword();

        String password = String.valueOf(passwordCharArray);

        //Step1: Check in the system user account directory if you have the user
        UserAccount userAccount = system.getUserAccountDirectory().authenticateUser(userName, password);

        Enterprise inEnterprise = null;
        Organization inOrganization = null;
        StateNetwork inNetwork = null;
        CountryNetwork outNetwork = null;
        if (userAccount == null) {
            //Step2: Go inside each network to check each enterprise
            for (CountryNetwork cnetwork : system.getNetworkList()) {
                for (StateNetwork network : cnetwork.getStateList()) {
                    //Step 2-a: Check against each enterprise
                    for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                        userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                        if (userAccount == null) {
                            //Step3: Check against each organization inside that enterprise
                            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);

                                if (userAccount != null) {
                                    //    System.out.println("organi"+ organization.getName());
                                    inEnterprise = enterprise;
                                    inOrganization = organization;
                                    inNetwork = network;
                                    outNetwork = cnetwork;
                                    userNameJTextField.setEnabled(false);
                                    passwordField.setEnabled(false);
                                    break;
                                }
                            }
                        } else {
                            inNetwork = network;
                            inEnterprise = enterprise;
                            outNetwork = cnetwork;
                            userNameJTextField.setEnabled(false);
                            passwordField.setEnabled(false);
                            break;
                        }
                        if (inOrganization != null) {
                            break;
                        }
                    }
                    if (inEnterprise != null) {
                        break;
                    }
                }
            }
        } else {
            for (CountryNetwork countryNetwork : system.getNetworkList()) {
                if (countryNetwork.getName().equalsIgnoreCase(userName)) {
                    outNetwork = countryNetwork;
                }
            }
        }

        if (userAccount == null) {
            fail++;
            JOptionPane.showMessageDialog(null, "Invalid Credentails!");
            userNameJTextField.setText("");
            passwordField.setText("");
            if (fail == 3) {
                try {
                    JOptionPane.showMessageDialog(null, "Wrong password 3 times. Try after 30 secs.");
                   
                    Thread.sleep(2000);

                } catch (InterruptedException ex) {
                    return;
                }
            }
            return;
        } else {
            CardLayout layout = (CardLayout) container.getLayout();
            container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, inNetwork, outNetwork, system));
            layout.next(container);
            //lblWelcome.setText("Welcome" + userAccount.getEmployee().getName());
        }
        loginJButton.setEnabled(false);
        btnSignUp.setEnabled(false);
        logoutJButton.setEnabled(true);
//        userNameJTextField.setEnabled(false);
//        passwordField.setEnabled(false);

    }//GEN-LAST:event_loginJButtonActionPerformed

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        logoutJButton.setEnabled(false);
        userNameJTextField.setEnabled(true);
        passwordField.setEnabled(true);
        loginJButton.setEnabled(true);
        btnSignUp.setEnabled(true);
        userNameJTextField.setText("");
        passwordField.setText("");

        container.removeAll();
        JPanel blankJP = new JPanel();
        container.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) container.getLayout();
        crdLyt.next(container);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_logoutJButtonActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:

        SignUpWelcome panel = new SignUpWelcome(container, system);
        container.add("SignUpWelcome", panel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);

    }//GEN-LAST:event_btnSignUpActionPerformed

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //loginJButtonActionPerformed(evt)  ;

            String userName = userNameJTextField.getText();
            // Get Password
            char[] passwordCharArray = passwordField.getPassword();

            String password = String.valueOf(passwordCharArray);

            //Step1: Check in the system user account directory if you have the user
            UserAccount userAccount = system.getUserAccountDirectory().authenticateUser(userName, password);

            Enterprise inEnterprise = null;
            Organization inOrganization = null;
            StateNetwork inNetwork = null;
            CountryNetwork outNetwork = null;
            if (userAccount == null) {
                //Step2: Go inside each network to check each enterprise
                for (CountryNetwork cnetwork : system.getNetworkList()) {
                    for (StateNetwork network : cnetwork.getStateList()) {
                        //Step 2-a: Check against each enterprise
                        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                            userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                            if (userAccount == null) {
                                //Step3: Check against each organization inside that enterprise
                                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                    userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);

                                    if (userAccount != null) {
                                        //    System.out.println("organi"+ organization.getName());
                                        inEnterprise = enterprise;
                                        inOrganization = organization;
                                        inNetwork = network;
                                        outNetwork = cnetwork;
                                        break;
                                    }
                                }
                            } else {
                                inNetwork = network;
                                inEnterprise = enterprise;
                                outNetwork = cnetwork;
                                break;
                            }
                            if (inOrganization != null) {
                                break;
                            }
                        }
                        if (inEnterprise != null) {
                            break;
                        }
                    }
                }
            } else {
                for (CountryNetwork countryNetwork : system.getNetworkList()) {
                    if (countryNetwork.getName().equalsIgnoreCase(userName)) {
                        outNetwork = countryNetwork;
                    }
                }
            }

            if (userAccount == null) {
                JOptionPane.showMessageDialog(null, "Invalid Credentails!");
                return;
            } else {
                CardLayout layout = (CardLayout) container.getLayout();
                container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, inNetwork, outNetwork, system));
                layout.next(container);
            }
            loginJButton.setEnabled(false);
            btnSignUp.setEnabled(false);
            logoutJButton.setEnabled(true);
            userNameJTextField.setEnabled(false);
            passwordField.setEnabled(false);

        }
    }//GEN-LAST:event_passwordFieldKeyPressed

    private void btnHomelessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomelessActionPerformed
        // TODO add your handling code here:
        CountryNetwork c = (CountryNetwork) comboCountry.getSelectedItem();
        StateNetwork s = (StateNetwork) comboState.getSelectedItem();
        if (c != null && s != null) {
            HomelessFoundJPanel manageOrganizationJPanel = new HomelessFoundJPanel(container, null, null, null, s, c, system);
            container.add("HomelessFoundJPanel1", manageOrganizationJPanel);
            CardLayout layout = (CardLayout) container.getLayout();
            layout.next(container);
        } else {
            JOptionPane.showMessageDialog(null, "Please select the state and country");
        }
    }//GEN-LAST:event_btnHomelessActionPerformed

    private void comboCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCountryActionPerformed
        // TODO add your handling code here:

        CountryNetwork c = (CountryNetwork) comboCountry.getSelectedItem();
        if (c != null) {
            comboState.removeAllItems();
            for (StateNetwork stateNetwork : c.getStateList()) {
                comboState.addItem(stateNetwork);
            }
        }
    }//GEN-LAST:event_comboCountryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHomeless;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JComboBox comboCountry;
    private javax.swing.JComboBox comboState;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton loginJButton;
    private javax.swing.JLabel loginJLabel;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameJTextField;
    // End of variables declaration//GEN-END:variables
}
