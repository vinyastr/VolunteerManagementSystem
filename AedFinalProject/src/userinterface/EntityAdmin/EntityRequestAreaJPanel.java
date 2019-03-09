/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EntityAdmin;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Role.EducationAdmin;
import Business.Role.HospitalAdmin;
import Business.Role.IndividualAdmin;
import Business.Role.MNCAdmin;
import Business.Role.NGOAdmin;
import Business.SignUp.SignUpRequest;
import Business.SignUp.SignUpRequestOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.mail.SendFailedException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import utility.Validator;

/**
 *
 * @author prashantreddy
 */
public class EntityRequestAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EntityManageRequestJPanel
     */
    private Enterprise enterprise;
    private UserAccount account;
    private CountryNetwork country;
    private StateNetwork state;
    private EcoSystem system;
    private JPanel userProcessContainer;
    
    public EntityRequestAreaJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, StateNetwork network, CountryNetwork cNetwork, EcoSystem business) {
        initComponents();
        //this.organizationDir = organizationDir;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = business;
        this.state = network;
        this.country = cNetwork;
        this.account = account;
        populateWorkQueueTable();
    }
    
    public void populateWorkQueueTable() {
        try {
            lblWarning.setText("");
            DefaultTableModel model = (DefaultTableModel) tblReq.getModel();
            
            model.setRowCount(0);
            if (enterprise != null) {
                if (enterprise.getWorkQueue() != null) {
                    if (enterprise.getWorkQueue().getWorkRequestList().size() > 0) {
                        for (WorkRequest work : enterprise.getWorkQueue().getWorkRequestList()) {
                            // populate the work request
                            if (work instanceof SignUpRequestOrganization) {
                                lblWarning.setText("");
                                SignUpRequestOrganization s = (SignUpRequestOrganization) work;
                                Object[] row = new Object[6];
                                row[0] = s.getOrgName();
                                row[1] = s.getReceiver();
                                row[2] = s.getEnterprise();
                                row[3] = s.getOrgType().getValue();
                                row[4] = s.getCity();
                                row[5] = s;
                                
                                model.addRow(row);
                                
                            }
                            
                        }
                    } else {
                        //lblWarning.setText("*Work Request is not Available");
                        
                    }
                } else {
                    lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
                    
                }
            } else {
                //lblWarning.setText("*Enterprise is not Available");
                
            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblReq = new javax.swing.JTable();
        btnAssign = new javax.swing.JButton();
        btnComplete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        lblWarning = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setForeground(new java.awt.Color(71, 79, 112));

        tblReq.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        tblReq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Organization Name", "Reciever", "Enterprise", "Org Type", "City", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReq);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 770, 182));

        btnAssign.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnAssign.setForeground(new java.awt.Color(71, 79, 112));
        btnAssign.setText("Assign to me");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });
        add(btnAssign, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 150, 40));

        btnComplete.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnComplete.setForeground(new java.awt.Color(71, 79, 112));
        btnComplete.setText("Serve");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });
        add(btnComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, 120, 40));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(71, 79, 112));
        jLabel1.setText("Request Recieved");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(71, 79, 112));
        jLabel3.setText("Entity Admin Request Area Panel");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 450, -1));

        backJButton.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(71, 79, 112));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 110, 40));

        lblWarning.setForeground(new java.awt.Color(255, 0, 0));
        add(lblWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 720, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/global-world-map-background-business-template-d-globe-40201747.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -4, 1300, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        try {
            lblWarning.setText("");
            int selectedRow = tblReq.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                
                SignUpRequest p = (SignUpRequest) tblReq.getValueAt(selectedRow, 5);
                //Assigning the request
                if (p.getStatus().equals("Requested")) {
                    
                    p.setStatus("Pending");
                    p.setReceiver(account);
                    
                    populateWorkQueueTable();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Already assigned");
                }
                
            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
            
        }
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        // TODO add your handling code here:
        try{lblWarning.setText("");
        int selectedRow = tblReq.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            SignUpRequest p = (SignUpRequest) tblReq.getValueAt(selectedRow, 5);
            SignUpRequestOrganization orgRequest = null;
            UserAccount acc = null;
            
            if (p.getReceiver() != null) {
                if (p.getStatus().equals("Pending")) {
                    if (p instanceof SignUpRequestOrganization) {
                        try {
                            Validator.sendMessage(p.getEmail(),Validator.ACCOUNT_ACTIVATION);
                        } catch (SendFailedException ex) {
                            JOptionPane.showMessageDialog(null, "User has a wrong email address");
                            p.setStatus("Cancelled");
                            return;
                        }
                        orgRequest = (SignUpRequestOrganization) p;
                       
                        Employee emp = new Employee();
                        emp.setName(p.getName());
                        emp.setEmailId(p.getEmail());
                        Enterprise e = orgRequest.getEnterprise();
                        CountryNetwork country = orgRequest.getCountry();
                        StateNetwork state = orgRequest.getState();
                        // Creating a Organization and user Account for the request
                        Organization org = e.getOrganizationDirectory().createOrganization(orgRequest.getOrgType(), orgRequest.getName(), orgRequest.getCity(), orgRequest.getLatLong());
                        
                        if (orgRequest.getOrgType() == Organization.Type.MNC) {
                            acc = org.getUserAccountDirectory().createUserAccount(p.getUserName(), p.getPassword(), emp, new MNCAdmin());
                        } else if (orgRequest.getOrgType() == Organization.Type.Education) {
                            acc = org.getUserAccountDirectory().createUserAccount(p.getUserName(), p.getPassword(), emp, new EducationAdmin());
                        } else if (orgRequest.getOrgType() == Organization.Type.Individuals) {
                            acc = org.getUserAccountDirectory().createUserAccount(p.getUserName(), p.getPassword(), emp, new IndividualAdmin());
                        } else if (orgRequest.getOrgType() == Organization.Type.Hospital) {
                            acc = org.getUserAccountDirectory().createUserAccount(p.getUserName(), p.getPassword(), emp, new HospitalAdmin());
                        } else if (orgRequest.getOrgType() == Organization.Type.NGO) {
                            acc = org.getUserAccountDirectory().createUserAccount(p.getUserName(), p.getPassword(), emp, new NGOAdmin());
                        }
                        
                    }
                    
                    p.setStatus("Complete");
                    JOptionPane.showMessageDialog(null, "You have successfully completed the request");
                    
                    populateWorkQueueTable();
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot complete it two times.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please assign first");
            }
            
        }
        }catch(Exception ex){
                lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
                }
    }//GEN-LAST:event_btnCompleteActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnComplete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JTable tblReq;
    // End of variables declaration//GEN-END:variables
}
