/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EntityAdmin.Education;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Event.Event;
import Business.Event.EventDirectory;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Organization.EducationOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BeneficiaryWorkRequest;
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
public class EducationRequestAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EntityManageRequestJPanel
     */
    private Enterprise enterprise;
    private UserAccount account;
    private CountryNetwork country;
    private StateNetwork state;
    private EcoSystem system;
    private JPanel userProcessContainer;
    private EducationOrganization organization;

    public EducationRequestAreaJPanel(JPanel userProcessContainer, UserAccount account, EducationOrganization organization, Enterprise enterprise, StateNetwork network, CountryNetwork cNetwork, EcoSystem business) {
        initComponents();
        //this.organizationDir = organizationDir;
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

            DefaultTableModel model = (DefaultTableModel) tblReq.getModel();

            model.setRowCount(0);

            if (organization != null) {
                if (organization.getWorkQueue() != null) {
                    if (organization.getWorkQueue().getWorkRequestList().size() > 0) {

                        for (WorkRequest work : organization.getWorkQueue().getWorkRequestList()) {
                            if (work instanceof BeneficiaryWorkRequest) {
                                lblWarning.setText("");

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
                        lblWarning.setText("*NO Work Requests are Available for " + organization.getName());
                    }
                } else {
                    lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
                }
            } else {
                lblWarning.setText("* " + organization.getName() + " is not Available");
            }
            if (enterprise != null) {
                if (enterprise.getWorkQueue() != null) {
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
                        //lblWarning.setText("*Work Request is not present");
                    }
                } else {
                    lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
                }
            } else {
                lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");

            }

        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
        }
    }

    public void populateUpdatedTable() {
        try {
            lblWarning.setText("");
            DefaultTableModel model = (DefaultTableModel) UpdatedJTable.getModel();

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
                //lblWarning.setText("*NO Events are present");
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
        jLabel4 = new javax.swing.JLabel();
        lblWarning = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setForeground(new java.awt.Color(71, 79, 112));

        tblReq.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        tblReq.setForeground(new java.awt.Color(71, 79, 112));
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 690, 182));

        jScrollPane2.setForeground(new java.awt.Color(71, 79, 112));

        UpdatedJTable.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        UpdatedJTable.setForeground(new java.awt.Color(71, 79, 112));
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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 690, 198));

        btnAssign.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnAssign.setForeground(new java.awt.Color(71, 79, 112));
        btnAssign.setText("View Details");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });
        add(btnAssign, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 150, 40));

        btnComplete.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnComplete.setForeground(new java.awt.Color(71, 79, 112));
        btnComplete.setText("Serve");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });
        add(btnComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 390, 90, 40));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Event List");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, -1, -1));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 308, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(71, 79, 112));
        jLabel3.setText("Education Admin Request Area Panel");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 530, -1));

        backJButton.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(71, 79, 112));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 770, 110, 40));

        jLabel4.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(71, 79, 112));
        jLabel4.setText("Request Received");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, -1));

        lblWarning.setForeground(new java.awt.Color(255, 0, 0));
        add(lblWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 830, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/global-world-map-background-business-template-d-globe-40201747.jpg"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -4, 1300, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // Viewing the details to serve the request
        try {
            lblWarning.setText("");
            int selectedRow = tblReq.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                BeneficiaryWorkRequest p = (BeneficiaryWorkRequest) tblReq.getValueAt(selectedRow, 4);

                p.setStatus("Pending");

                populateWorkQueueTable();
                EducationViewDetailsJPanel RequestAreaJPanel = new EducationViewDetailsJPanel(userProcessContainer, account, organization, enterprise, state, country, system, p);
                userProcessContainer.add("EducationViewDetailsJPanel", RequestAreaJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);

            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
        }
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        // TODO add your handling code here:
        try {
            lblWarning.setText("");
            int selectedRow = tblReq.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                BeneficiaryWorkRequest p = (BeneficiaryWorkRequest) tblReq.getValueAt(selectedRow, 4);
                if (!p.getStatus().equals("Complete")) {
                    if (organization.getEventDirectory() == null) {
                        organization.setEventDirectory(new EventDirectory());
                    }
                    //Creating the event for Volunteers
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
                            // Logger.getLogger(EducationRequestAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JTable tblReq;
    // End of variables declaration//GEN-END:variables
}
