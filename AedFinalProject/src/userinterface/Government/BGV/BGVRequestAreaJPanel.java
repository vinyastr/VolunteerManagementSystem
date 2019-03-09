/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Government.BGV;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.SignUp.SignUpRequest;
import Business.SignUp.SignUpRequestOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author prashantreddy
 */
public class BGVRequestAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EntityManageRequestJPanel
     */

    private Enterprise enterprise;
    UserAccount account;
    CountryNetwork country;
    StateNetwork state;
    EcoSystem system;
    Organization organization;
    JPanel userProcessContainer;

    public BGVRequestAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, StateNetwork network, CountryNetwork cNetwork, EcoSystem business) {
        initComponents();
        this.organization = organization;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        //this.container = container;
        this.system = business;
        this.state = network;
        this.country = cNetwork;
        this.account = account;
        populateWorkQueueTable();
    }

    public void populateWorkQueueTable() {
        DefaultTableModel model = (DefaultTableModel) tblReq.getModel();

        model.setRowCount(0);
        if(organization.getWorkQueue()==null){
            organization.setWorkQueue(new WorkQueue());
        }
        for (WorkRequest work : organization.getWorkQueue().getWorkRequestList()) {
            if (work instanceof SignUpRequestOrganization) {
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAssign = new javax.swing.JButton();
        btnServe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReq = new javax.swing.JTable();
        userJButton = new javax.swing.JButton();
        backjButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAssign.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnAssign.setForeground(new java.awt.Color(71, 79, 112));
        btnAssign.setText("Assign to me");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });
        add(btnAssign, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 140, 40));

        btnServe.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnServe.setForeground(new java.awt.Color(71, 79, 112));
        btnServe.setText("Serve");
        btnServe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServeActionPerformed(evt);
            }
        });
        add(btnServe, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 410, 90, 40));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(71, 79, 112));
        jLabel1.setText("Verification Table");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 170, 20));

        jLabel3.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(71, 79, 112));
        jLabel3.setText("BGV Admin Request Area Panel");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 440, -1));

        jScrollPane1.setForeground(new java.awt.Color(71, 79, 112));

        tblReq.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        tblReq.setForeground(new java.awt.Color(71, 79, 112));
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 750, 182));

        userJButton.setForeground(new java.awt.Color(71, 79, 112));
        userJButton.setText("View Details");
        userJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButtonActionPerformed(evt);
            }
        });
        add(userJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 410, 120, 40));

        backjButton1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(71, 79, 112));
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });
        add(backjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 100, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/global-world-map-background-business-template-d-globe-40201747.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -4, 1300, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        
        int selectedRow = tblReq.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            SignUpRequest p = (SignUpRequest) tblReq.getValueAt(selectedRow, 5);

            if (p.getStatus().equals("Background Verification")) {
                p.setStatus("Pending");
                p.setReceiver(account);
                populateWorkQueueTable();

            } else {
                JOptionPane.showMessageDialog(null, "Already assigned");
            }

        }
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnServeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServeActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblReq.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            SignUpRequest p = (SignUpRequest) tblReq.getValueAt(selectedRow, 5);
            SignUpRequestOrganization orgRequest = null;
            UserAccount acc = null;
            //Approving the BGV request after verifying the document
            if (p.getReceiver() != null) {
                if (p.getStatus().equals("Pending")) {
                    if (p instanceof SignUpRequestOrganization) {
                        orgRequest = (SignUpRequestOrganization) p;
                        p.setStatus("Verified");
                        JOptionPane.showMessageDialog(null, "You have successfully Verified the request");

                        populateWorkQueueTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "You cannot complete it two times.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please assign first");
                }

            }
        }
    }//GEN-LAST:event_btnServeActionPerformed

    private void userJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButtonActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblReq.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            SignUpRequestOrganization p = (SignUpRequestOrganization) tblReq.getValueAt(selectedRow, 5);
            BGVViewDetailsJPane requestAreaJPanel = new BGVViewDetailsJPane(userProcessContainer, account, organization, enterprise, state, country, system, p);
            userProcessContainer.add("BGVViewDetailsJPane", requestAreaJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);

        }
    }//GEN-LAST:event_userJButtonActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnServe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReq;
    private javax.swing.JButton userJButton;
    // End of variables declaration//GEN-END:variables
}
