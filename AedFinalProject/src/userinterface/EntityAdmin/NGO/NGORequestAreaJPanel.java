/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EntityAdmin.NGO;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Event.Event;
import Business.Event.EventDirectory;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Organization.NGOOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BeneficiaryWorkRequest;
import Business.WorkQueue.WorkQueue;
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
public class NGORequestAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EntityManageRequestJPanel
     */
    private Enterprise enterprise;
    private UserAccount account;
    private CountryNetwork country;
    private StateNetwork state;
    private EcoSystem system;
    private JPanel userProcessContainer;
    private NGOOrganization organization;

    public NGORequestAreaJPanel(JPanel userProcessContainer, UserAccount account, NGOOrganization organization, Enterprise enterprise, StateNetwork network, CountryNetwork cNetwork, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = business;
        this.state = network;
        this.country = cNetwork;
        this.account = account;
        this.organization = organization;
        populateWorkQueueTable();
        populateUpdatedTable();

    }

    public void populateWorkQueueTable() {
        try {
            lblWarning.setText("");
            DefaultTableModel model = (DefaultTableModel) tblReq.getModel();
            // Display all the work queues in table
            model.setRowCount(0);
            if (organization.getWorkQueue() == null) {
                organization.setWorkQueue(new WorkQueue());
            }
            if (organization.getWorkQueue().getWorkRequestList().size() > 0) {
                for (WorkRequest work : organization.getWorkQueue().getWorkRequestList()) {
                    if (work instanceof BeneficiaryWorkRequest) {
                        BeneficiaryWorkRequest s = (BeneficiaryWorkRequest) work;
                        Object[] row = new Object[6];
                        row[0] = s.getSenderOrganization();
                        row[1] = s.getEventName();
                        row[2] = s.getNumberOfVolunteersRequest();
                        row[3] = s.getEventDate();
                        row[4] = s;
                        model.addRow(row);
                    }

                }
            } else {
                //lblWarning.setText("*Work Request is not Available");
            }
            if (enterprise.getWorkQueue() == null) {
                enterprise.setWorkQueue(new WorkQueue());
            }
            if (enterprise.getWorkQueue().getWorkRequestList().size() > 0) {
                for (WorkRequest work : enterprise.getWorkQueue().getWorkRequestList()) {
                    if (work instanceof BeneficiaryWorkRequest) {
                        BeneficiaryWorkRequest s = (BeneficiaryWorkRequest) work;
                        Object[] row = new Object[6];
                        //System.out.println("qwe"+s.getSenderOrganization());
                        row[0] = s.getSenderOrganization();
                        row[1] = s.getEventName();
                        row[2] = s.getNumberOfVolunteersRequest();
                        row[3] = s.getEventDate();
                        row[4] = s;
                        model.addRow(row);
                    }
                }
            } else {
                //lblWarning.setText("*Work Request is not Available");

            }

        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
        }
    }

    public void populateUpdatedTable() {
        try {
            lblWarning.setText("");
            DefaultTableModel model = (DefaultTableModel) UpdatedJTable.getModel();
            //populating the event Directory based on the work requested selected
            model.setRowCount(0);
            if (organization.getEventDirectory() == null) {
                organization.setEventDirectory(new EventDirectory());
            }
            if (organization.getEventDirectory().getEventDirectory().size() > 0) {
                for (Event event : organization.getEventDirectory().getEventDirectory()) {
                    Object[] row = new Object[6];
                    row[0] = event.getEventId();
                    row[1] = event.getSenderOrganization();
                    row[2] = event.getAvailVolunteers();
                    row[3] = event;
                    row[4] = event.getEventDate();
                    model.addRow(row);
                }
            } else {
                lblWarning.setText("*Events are not Available");

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
        jScrollPane2 = new javax.swing.JScrollPane();
        UpdatedJTable = new javax.swing.JTable();
        btnAssign = new javax.swing.JButton();
        btnComplete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        lblWarning = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setForeground(new java.awt.Color(71, 79, 112));

        tblReq.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        tblReq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Organization Name", "Event Name", "Volunteers Required", "Event Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReq);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 690, 182));

        jScrollPane2.setForeground(new java.awt.Color(71, 79, 112));

        UpdatedJTable.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        UpdatedJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Event Id", "Organization Name", "Available Volunteers", "Event Name", "Event Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(UpdatedJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 680, 198));

        btnAssign.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnAssign.setForeground(new java.awt.Color(71, 79, 112));
        btnAssign.setText("View Details");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });
        add(btnAssign, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, -1, 40));

        btnComplete.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnComplete.setForeground(new java.awt.Color(71, 79, 112));
        btnComplete.setText("Serve");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });
        add(btnComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(842, 330, 90, 40));

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(71, 79, 112));
        jLabel1.setText("Request Recieved");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 308, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(71, 79, 112));
        jLabel3.setText("NGO Admin Request Area Panel");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 460, -1));

        backJButton.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(71, 79, 112));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, -1, 40));

        lblWarning.setForeground(new java.awt.Color(255, 51, 0));
        add(lblWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 710, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/global-world-map-background-business-template-d-globe-40201747.jpg"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -4, 1300, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        
        try {
            lblWarning.setText("");
            int selectedRow = tblReq.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                // Assigning the request for himself
                BeneficiaryWorkRequest p = (BeneficiaryWorkRequest) tblReq.getValueAt(selectedRow, 4);
                p.setStatus("Pending");
                populateWorkQueueTable();
                NGOViewDetailsJPanel RequestAreaJPanel = new NGOViewDetailsJPanel(userProcessContainer, account, organization, enterprise, state, country, system, p);
                userProcessContainer.add("NGOViewDetailsJPanel", RequestAreaJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);

            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");

        }
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        // Completing the request by providing all the volunteers required
        try {
            lblWarning.setText("");
            int selectedRow = tblReq.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                //Completing the request by providing all the volunteers required
                BeneficiaryWorkRequest p = (BeneficiaryWorkRequest) tblReq.getValueAt(selectedRow, 4);
                if (!p.getStatus().equals("Complete")) {
                    if (organization.getEventDirectory() == null) {
                        organization.setEventDirectory(new EventDirectory());
                    }
                    Event event = organization.getEventDirectory().createEvent();
                    event.setAvailVolunteers(p.getNumberOfVolunteersRequest());
                    event.setEventDate(p.getEventDate());
                    event.setEventName(p.getEventName());
                    event.setRequiredVolunteers(p.getNumberOfVolunteersRequest());
                    event.setServingOrganization(organization);
                    event.setSenderOrganization(p.getSenderOrganization());
                    p.setNumberOfVolunteersRequest(p.getNumberOfVolunteersRequest() - event.getAvailVolunteers());
                    p.getEventDirectory().getEventDirectory().add(event);
                    if (p.getNumberOfVolunteersRequest() == 0 && p.isLogisticRequest() == true) {
                        try {
                            p.setStatus("Complete");
                            Validator.sendMessage(p.getSender().getEmployee().getEmailId(), Validator.EVENT_REQUEST);
                        } catch (SendFailedException ex) {
                            
                        }
                    }
                    JOptionPane.showMessageDialog(null, "You have successfully completed the request");
                    populateWorkQueueTable();
                    populateUpdatedTable();
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot complete it two times.");
                }
            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");

        }
    }//GEN-LAST:event_btnCompleteActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable UpdatedJTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnComplete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JTable tblReq;
    // End of variables declaration//GEN-END:variables
}
