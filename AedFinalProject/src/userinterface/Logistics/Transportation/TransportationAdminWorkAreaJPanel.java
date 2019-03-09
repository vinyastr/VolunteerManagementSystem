/*
 * AdminWorkAreaJPanel.java
 *
 * Created on October 10, 2008, 8:50 AM
 */
package userinterface.Logistics.Transportation;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Organization.TransportOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BeneficiaryWorkRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class TransportationAdminWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private TransportOrganization organization;
    private Enterprise enterprise;
    private EcoSystem business;

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public TransportationAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, TransportOrganization organization, Enterprise enterprise, StateNetwork network, CountryNetwork cNetwork, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        this.business = business;
        this.organization = organization;

        populateWorkQueueTable();
    }



    public void populateWorkQueueTable() {
        try {
            lblWarning.setText("");
            DefaultTableModel model = (DefaultTableModel) requestTable.getModel();

            model.setRowCount(0);
            // If logistics are required for the work request, populate values into table
            if (organization.getWorkQueue() != null) {
                if (organization.getWorkQueue().getWorkRequestList().size() > 0) {
                    for (WorkRequest work : organization.getWorkQueue().getWorkRequestList()) {
                        if (work instanceof BeneficiaryWorkRequest) {
                            BeneficiaryWorkRequest b = (BeneficiaryWorkRequest) work;
                            Object[] row = new Object[5];

                            row[0] = b.getSenderOrganization();
                            row[1] = b.getEventName();
                            row[2] = b.getEventDate();
                            row[3] = b;
                            row[4] = b.isLogisticRequest();
                            model.addRow(row);
                        }
                    }
                } else {
                    lblWarning.setText("*Work Request is not Available");
                }
            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
        }
    }


    public void populateView(int selectedRow) {
        // DefaultTableModel model = (DefaultTableModel) availableTable.getModel();
        try {
            lblWarning.setText("");
            String[] columns = {"Field", "Value"};
            DefaultTableModel model = (DefaultTableModel) tblView.getModel();
            model.setRowCount(0);
            // Based on the selected row ppulate the value associated to it.
            WorkRequest p = (WorkRequest) requestTable.getValueAt(selectedRow, 3);
            if (p instanceof BeneficiaryWorkRequest) {

                Object[] rowData1 = {"Event Name", ((BeneficiaryWorkRequest) p).getEventName()};
                model.addRow(rowData1);
                Object[] rowData2 = {"Event Date", ((BeneficiaryWorkRequest) p).getEventDate()};
                model.addRow(rowData2);
                Object[] rowData3 = {"Event Details", ((BeneficiaryWorkRequest) p).getEventDetails()};
                model.addRow(rowData3);
                Object[] rowData4 = {"Vehicle Type", ((BeneficiaryWorkRequest) p).getTypeOfVehicle()};
                model.addRow(rowData4);
                Object[] rowData5 = {"No Of Vehicle", ((BeneficiaryWorkRequest) p).getNoOfVehicle()};
                model.addRow(rowData5);
                Object[] rowData6 = {"Pick up Time", ((BeneficiaryWorkRequest) p).getPickupTime()};
                model.addRow(rowData6);
                Object[] rowData7 = {"Pick up Address", ((BeneficiaryWorkRequest) p).getAddress()};
                model.addRow(rowData7);

//              Object[] row = new Object[4];
//            row[0] = e.getEventName();
//            row[1] = e.getServingOrganization().getName();
//            row[2] = e.getAvailVolunteers();
//            row[3] = e.getEventDate();
//            model.addRow(row);
            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
        }
    }
        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        btnComplete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblView = new javax.swing.JTable();
        lblWarning = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(71, 79, 112));
        jLabel1.setText("Transportation Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 370, -1));
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 130, 20));

        btnComplete.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnComplete.setForeground(new java.awt.Color(71, 79, 112));
        btnComplete.setText("Complete");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });
        add(btnComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 130, 40));

        jLabel4.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(71, 79, 112));
        jLabel4.setText("Vehicles Requested");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 210, 30));

        requestTable.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        requestTable.setForeground(new java.awt.Color(71, 79, 112));
        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Requested Organization", "Event Name", "Event Date", "Status", "Logistic Served"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        requestTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                requestTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(requestTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 650, 270));

        btnDelete.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(71, 79, 112));
        btnDelete.setText("Delete request");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, -1, 40));

        tblView.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        tblView.setForeground(new java.awt.Color(71, 79, 112));
        tblView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Field", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblView);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 410, 150));

        lblWarning.setForeground(new java.awt.Color(255, 0, 0));
        add(lblWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 790, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/global-world-map-background-business-template-d-globe-40201747.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -4, 1300, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        // TODO add your handling code here:
        try {
            lblWarning.setText("");
            int selectedRow = requestTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                // Complete the Beneficiary request if the logistic is served
                BeneficiaryWorkRequest work = (BeneficiaryWorkRequest) requestTable.getValueAt(selectedRow, 3);
                if (!(work.getStatus().equals("Completed")) && !work.isLogisticRequest()) {
                    work.setLogisticRequest(true);
                    if (work.getNumberOfVolunteersRequest() == 0 && work.isLogisticRequest() == true) {
                        work.setStatus("Complete");
                    }

                    JOptionPane.showMessageDialog(null, "You have successfully completed the request");
                    populateWorkQueueTable();
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot complete it two times.");
                }

            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
        }
    }//GEN-LAST:event_btnCompleteActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            lblWarning.setText("");
            int selectedRow = requestTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "Please select the row to delete the account", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                //Delete the selected request
                BeneficiaryWorkRequest p = (BeneficiaryWorkRequest) requestTable.getValueAt(selectedRow, 3);
                if (organization.getWorkQueue() != null) {
                    organization.getWorkQueue().getWorkRequestList().remove(p);
                    JOptionPane.showMessageDialog(null, "You have successfully deleted the account");
                    populateWorkQueueTable();
                }
            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void requestTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_requestTableMouseClicked
        // TODO add your handling code here:
        int selectedRow = requestTable.getSelectedRow();
        if (selectedRow >= 0) {
            populateView(selectedRow);
        }
    }//GEN-LAST:event_requestTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComplete;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JTable requestTable;
    private javax.swing.JTable tblView;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables

}
