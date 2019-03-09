/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EntityAdmin;

import Business.EcoSystem;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import utility.Validator;

/**
 *
 * @author Administrator
 */
public class EntityManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private JPanel container;
    private Enterprise enterprise;

    public EntityManageUserAccountJPanel(JPanel container, Enterprise enterprise) {
        initComponents();
        this.enterprise = enterprise;
        this.container = container;

        popOrganizationComboBox();
        popData();
    }

    public void popOrganizationComboBox() {
        organizationJComboBox.removeAllItems();
        try {
            lblWarning.setText("");

            if (enterprise.getOrganizationDirectory() != null) {
                if (enterprise.getOrganizationDirectory().getOrganizationList().size() > 0) {
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        organizationJComboBox.addItem(organization);
                    }
                } else {
                    lblWarning.setText("*NO Organization is available in the Enterprise");
                }
            } else {
                lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
        }
    }

    public void populateEmployeeComboBox(Organization organization) {
        employeeJComboBox.removeAllItems();
        try {
            lblWarning.setText("");
            if (organization.getEmployeeDirectory() != null) {
                if (organization.getEmployeeDirectory().getEmployeeList().size() > 0) {
                    for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
                        employeeJComboBox.addItem(employee);
                    }
                } else {
                    lblWarning.setText("*NO Employees present for this Organization");
                }
            } else {
                lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
        }
    }

    private void populateRoleComboBox(Organization e) {
        roleJComboBox.removeAllItems();
        try {
            lblWarning.setText("");
            if (e != null) {
                if (e.getSupportedRole() != null) {
                    for (Role role : e.getSupportedRole()) {
                        roleJComboBox.addItem(role);
                    }
                } else {
                    lblWarning.setText("*NO Roles Available for this Organization. Please Add Roles");
                }
            } else {
                lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
        }
    }

    public void popData() {
        try {
            lblWarning.setText("");
            DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

            model.setRowCount(0);
            if (enterprise.getOrganizationDirectory() != null) {
                if (enterprise.getOrganizationDirectory().getOrganizationList().size() > 0) {

                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization.getUserAccountDirectory() != null) {
                            if (organization.getUserAccountDirectory().getUserAccountList().size() > 0) {
                                //Displaying all the user Account
                                for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                                    Object row[] = new Object[2];
                                    row[0] = ua;
                                    row[1] = ua.getRole();
                                    ((DefaultTableModel) userJTable.getModel()).addRow(row);
                                }
                            } else {
                               // lblWarning.setText("*User Accounts are not present");
                            }
                        } else {
                            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");

                        }
                    }

                } else {
                    lblWarning.setText("*NO Organization is Available");
                }
            } else {
                lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
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

        createUserJButton = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox();
        backjButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        pwdFiledPassword = new javax.swing.JPasswordField();
        lblUserName = new javax.swing.JLabel();
        lblAcceptedUserName = new javax.swing.JLabel();
        lblWarning = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        createUserJButton.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        createUserJButton.setForeground(new java.awt.Color(71, 79, 112));
        createUserJButton.setText("Create");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });
        add(createUserJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 510, 110, 40));

        nameJTextField.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        nameJTextField.setForeground(new java.awt.Color(71, 79, 112));
        nameJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameJTextFieldFocusLost(evt);
            }
        });
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 146, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(71, 79, 112));
        jLabel1.setText("User Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 100, -1));

        jScrollPane1.setForeground(new java.awt.Color(71, 79, 112));

        userJTable.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        userJTable.setForeground(new java.awt.Color(71, 79, 112));
        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userJTable);
        if (userJTable.getColumnModel().getColumnCount() > 0) {
            userJTable.getColumnModel().getColumn(0).setResizable(false);
            userJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 90, 460, 179));

        jLabel2.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(71, 79, 112));
        jLabel2.setText("Password");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 80, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(71, 79, 112));
        jLabel3.setText("Employee");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, -1, -1));

        employeeJComboBox.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        employeeJComboBox.setForeground(new java.awt.Color(71, 79, 112));
        add(employeeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 146, -1));

        backjButton1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(71, 79, 112));
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });
        add(backjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 112, 50));

        jLabel5.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(71, 79, 112));
        jLabel5.setText("Organization");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 120, -1));

        organizationJComboBox.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        organizationJComboBox.setForeground(new java.awt.Color(71, 79, 112));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 146, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(71, 79, 112));
        jLabel4.setText("Role");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));

        roleJComboBox.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        roleJComboBox.setForeground(new java.awt.Color(71, 79, 112));
        add(roleJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 146, -1));

        pwdFiledPassword.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        pwdFiledPassword.setForeground(new java.awt.Color(71, 79, 112));
        pwdFiledPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pwdFiledPasswordFocusLost(evt);
            }
        });
        add(pwdFiledPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 150, 30));

        lblUserName.setForeground(new java.awt.Color(255, 0, 0));
        add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, -1, -1));

        lblAcceptedUserName.setForeground(new java.awt.Color(0, 204, 51));
        add(lblAcceptedUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, -1, -1));

        lblWarning.setForeground(new java.awt.Color(255, 51, 0));
        add(lblWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, -1, -1));

        jLabel6.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(71, 79, 112));
        jLabel6.setText("Manage User Account");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 310, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/global-world-map-background-business-template-d-globe-40201747.jpg"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -4, 1300, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
        //Creating User Account for Entity
        try {
            lblWarning.setText("");
            lblAcceptedUserName.setText("");
            lblUserName.setText("");
            String userName = nameJTextField.getText();
            String password = String.valueOf(pwdFiledPassword.getPassword());
            if (!(userName.equals(""))) {                                                               // checking whether the username is empty     
                if (!password.isEmpty()) {
                    if (organizationJComboBox.getSelectedItem() != null) {
                        if (employeeJComboBox.getSelectedItem() != null) {
                            if (roleJComboBox.getSelectedItem() != null) {
                                // Creating user account
                                Organization organization = (Organization) organizationJComboBox.getSelectedItem();
                                Employee employee = (Employee) employeeJComboBox.getSelectedItem();
                                Role role = (Role) roleJComboBox.getSelectedItem();
                                if (organization != null) {
                                    organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                                    JOptionPane.showMessageDialog(null, "Account created succesfull");
                                    nameJTextField.setText("");
                                    pwdFiledPassword.setText("");
                                    popData();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Organization not available.", "Warning", JOptionPane.WARNING_MESSAGE);
                                }

                            } else {
                                lblWarning.setText("*NO Roles are Available");
                            }
                        } else {
                            lblWarning.setText("*NO Employees are Available, please Add Employees");
                        }
                    } else {
                        lblWarning.setText("*Organization is not available");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Enter value for password", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Enter value for username", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
        }
    }//GEN-LAST:event_createUserJButtonActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null) {
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void pwdFiledPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdFiledPasswordFocusLost
        // TODO add your handling code here:
        String password = String.valueOf(pwdFiledPassword.getPassword());
        if (!password.isEmpty()) {
            if (!Validator.validatePassword(password)) {
                JOptionPane.showMessageDialog(null, "Password should Contain \n"
                        + "       # At least one digit\n"
                        + "       # At least one lower case letter\n"
                        + "       # At least one upper case letter\n"
                        + "       # At least one special character(!@#$%^&+=~|?)\n"
                        + "       # no whitespace allowed in the entire string\n"
                        + "       # at least eight characters");
                pwdFiledPassword.setText("");
            }
        }
    }//GEN-LAST:event_pwdFiledPasswordFocusLost

    private void nameJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameJTextFieldFocusLost
        // TODO add your handling code here:
        String userName = nameJTextField.getText();
        if (!nameJTextField.getText().isEmpty()) {
            if (!Validator.validateUserName(nameJTextField.getText())) {
                lblAcceptedUserName.setText("");
                lblUserName.setText("*Only AlphaNumeric Characters and '_' and '.' are allowed");
                nameJTextField.setText("");
            } else if (!EcoSystem.checkIfUsernameIsUnique(nameJTextField.getText())) {
                lblAcceptedUserName.setText("");
                lblAcceptedUserName.setText("*" + userName + " " + "is already taken please enter new username");
                nameJTextField.setText("");
            } else {

                lblUserName.setText("");
                lblAcceptedUserName.setText(userName + " " + "is available");
            }
        }
    }//GEN-LAST:event_nameJTextFieldFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAcceptedUserName;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JPasswordField pwdFiledPassword;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
