/*
 * AdminWorkAreaJPanel.java
 *
 * Created on October 10, 2008, 8:50 AM
 */
package userinterface.CountryAdminWorkAreas;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Role.BeneficiaryAdminRole;
import Business.Role.EntityAdminRole;
import Business.Role.GovtAdminRole;
import Business.Role.LogisticAdminRole;
import Business.SignUp.SignUpRequest;
import Business.SignUp.SignUpRequestEnterprise;
import Business.SignUp.SignUpRequestState;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.mail.SendFailedException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import utility.Validator;

/**
 *
 * @author vinya
 */
public class CountryAdminRequestAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    EcoSystem system;
    CountryNetwork cNetwork;

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public CountryAdminRequestAreaJPanel(JPanel userProcessContainer, UserAccount account, CountryNetwork cNetwork, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = business;
        this.account = account;
        this.cNetwork = cNetwork;
        populateWorkQueueTable();

    }
// Populating the Work Queue Table
    public void populateWorkQueueTable() {
        DefaultTableModel model = (DefaultTableModel) requestTable.getModel();

        model.setRowCount(0);
        SignUpRequest s = null;
        for (WorkRequest work : account.getWorkQueue().getWorkRequestList()) {
            if (work instanceof SignUpRequestState) {
                s = (SignUpRequestState) work;
            } else if (work instanceof SignUpRequestEnterprise) {
                s = (SignUpRequestEnterprise) work;
            }
            Object[] row = new Object[4];
            row[0] = s.getName();
            row[1] = s.getReceiver();
            row[2] = s.getRequestDate();
            row[3] = s;

            model.addRow(row);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        reqBtn = new javax.swing.JButton();
        btnComplete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(71, 79, 112));
        jLabel1.setText("Work Area: Country Admin");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 380, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(71, 79, 112));
        jLabel4.setText("Request for State Creation");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 300, 30));

        jScrollPane2.setForeground(new java.awt.Color(71, 79, 112));

        requestTable.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        requestTable.setForeground(new java.awt.Color(71, 79, 112));
        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "State Name", "Receiver", "Request Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(requestTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 850, 330));

        btnDelete.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(71, 79, 112));
        btnDelete.setText("Delete request");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 600, 150, 40));

        reqBtn.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        reqBtn.setForeground(new java.awt.Color(71, 79, 112));
        reqBtn.setText("Assign To Me");
        reqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqBtnActionPerformed(evt);
            }
        });
        add(reqBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 600, 130, 40));

        btnComplete.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnComplete.setForeground(new java.awt.Color(71, 79, 112));
        btnComplete.setText("Complete");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });
        add(btnComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 600, 140, 40));

        btnBack.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(71, 79, 112));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 740, -1, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/global-world-map-background-business-template-d-globe-40201747.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -4, 1300, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestTable.getSelectedRow();
        if (selectedRow >= 0) {

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to delete the details", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {

                WorkRequest p = (WorkRequest) requestTable.getValueAt(selectedRow, 3);
                account.getWorkQueue().getWorkRequestList().remove(p);
                JOptionPane.showMessageDialog(null, "You have successfully deleted the account");
                populateWorkQueueTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Row from table ", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void reqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqBtnActionPerformed
        int selectedRow = requestTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            SignUpRequest p = (SignUpRequest) requestTable.getValueAt(selectedRow, 3);

            if (p.getStatus().equals("Requested")) {
                p.setStatus("Pending");
                p.setReceiver(account);

                populateWorkQueueTable();

            } else {
                JOptionPane.showMessageDialog(null, "Already assigned");
            }

        }
    }//GEN-LAST:event_reqBtnActionPerformed

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            SignUpRequest p = (SignUpRequest) requestTable.getValueAt(selectedRow, 3);
            SignUpRequestState s = null;
            SignUpRequestEnterprise e = null;

            if (p.getReceiver() != null) {
                if (p.getStatus().equals("Pending")) {
                    if (p instanceof SignUpRequestState) {
                        s = (SignUpRequestState) p;
                        StateNetwork net = cNetwork.createAndAddNetwork();
                        net.setName(p.getName());
                    } else if (p instanceof SignUpRequestEnterprise) {
                        e = (SignUpRequestEnterprise) p;
                        try {
                            Validator.sendMessage(p.getEmail(),Validator.ACCOUNT_ACTIVATION);
                        } catch (SendFailedException ex) {
                            JOptionPane.showMessageDialog(null, "User has a wrong email address");
                            p.setStatus("Cancelled");
                            p.setMessage("Not a Valid Email Address");
                            p.setRequestDate(new Date());
                            return;
                        }
                        //You can check for non duplicate of enterprise here.
                        Enterprise enterprise = e.getState().getEnterpriseDirectory().createAndAddEnterprise(e.getName(), e.getEnterprise());

                        Employee emp = new Employee();
                        emp.setName(p.getName());
                        emp.setEmailId(p.getEmail());
                        UserAccount user = null;
                        if (enterprise.getEnterpriseType() == Enterprise.EnterpriseType.Beneficiary) {
                            user = enterprise.getUserAccountDirectory().createUserAccount(p.getUserName(), p.getPassword(), emp, new BeneficiaryAdminRole());
                        } else if (enterprise.getEnterpriseType() == Enterprise.EnterpriseType.Entity) {
                            user = enterprise.getUserAccountDirectory().createUserAccount(p.getUserName(), p.getPassword(), emp, new EntityAdminRole());
                        } else if (enterprise.getEnterpriseType() == Enterprise.EnterpriseType.Government) {
                            user = enterprise.getUserAccountDirectory().createUserAccount(p.getUserName(), p.getPassword(), emp, new GovtAdminRole());
                        } else if (enterprise.getEnterpriseType() == Enterprise.EnterpriseType.Logistic) {
                            user = enterprise.getUserAccountDirectory().createUserAccount(p.getUserName(), p.getPassword(), emp, new LogisticAdminRole());
                        }

                    }

                    p.setStatus("Complete");
                    p.setRequestDate(new Date());
                    JOptionPane.showMessageDialog(null, "You have successfully completed the request");

                    populateWorkQueueTable();
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot complete it two times.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please assign first");
            }

        }
    }//GEN-LAST:event_btnCompleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
         Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CountryAdminWorkAreaJPanel sysAdminwjp = (CountryAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnComplete;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton reqBtn;
    private javax.swing.JTable requestTable;
    // End of variables declaration//GEN-END:variables

}