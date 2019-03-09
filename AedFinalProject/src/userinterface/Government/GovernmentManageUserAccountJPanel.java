/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Government;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import utility.Validator;

/**
 *
 * @author Administrator
 */
public class GovernmentManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private JPanel container;
    private Enterprise enterprise;

    public GovernmentManageUserAccountJPanel(JPanel container, Enterprise enterprise) {
        initComponents();
        this.enterprise = enterprise;
        this.container = container;

        popOrganizationComboBox();
        popData();
    }

    public void popOrganizationComboBox() {
        try {
            lblWarning.setText("");
            organizationJComboBox.removeAllItems();
            if (enterprise.getOrganizationDirectory() == null) {
                enterprise.setOrganizationDirectory(new OrganizationDirectory());
            }
            if (enterprise.getOrganizationDirectory().getOrganizationList().size() > 0) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    organizationJComboBox.addItem(organization);
                }
            } else {
                lblWarning.setText("*Employee is not Available");
            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");

        }
    }

    public void populateEmployeeComboBox(Organization organization) {
        try {
            lblWarning.setText("");
            employeeJComboBox.removeAllItems();
            if (organization.getEmployeeDirectory() == null) {
                organization.setEmployeeDirectory(new EmployeeDirectory());
            }
            if (organization.getEmployeeDirectory().getEmployeeList().size() > 0) {
                for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
                    employeeJComboBox.addItem(employee);
                }
            } else {
                lblWarning.setText("*Employee is not Available");
            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
        }
    }

    private void populateRoleComboBox(Enterprise e) {
        try {
            lblWarning.setText("");
            roleJComboBox.removeAllItems();
            if (e != null) {
                if (e.getSupportedRole() != null) {

                    for (Role role : e.getSupportedRole()) {
                        roleJComboBox.addItem(role);
                    }
                }
            }
        } catch (Exception ex) {
            lblWarning.setText("*Sorry for the inconvinence. System is down, technical team is working on it. Contact -- poojithsShetty@gmail.com");
        }
    }

    public void popData() {
        try {
            //populating data of user Account
            lblWarning.setText("");
            DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

            model.setRowCount(0);
            if (enterprise.getOrganizationDirectory() == null) {
                enterprise.setOrganizationDirectory(new OrganizationDirectory());
            }
            if (enterprise.getOrganizationDirectory().getOrganizationList().size() > 0) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (organization.getUserAccountDirectory() == null) {
                        organization.setUserAccountDirectory(new UserAccountDirectory());
                    }
                    if (organization.getUserAccountDirectory().getUserAccountList().size() > 0) {
                        for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                            Object row[] = new Object[2];
                            row[0] = ua;
                            row[1] = ua.getRole();
                            ((DefaultTableModel) userJTable.getModel()).addRow(row);
                        }
                    }
                }
            } else {
                lblWarning.setText("*Organization is not Available");
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
        jLabel7 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblAcceptedUserName = new javax.swing.JLabel();
        lblWarning = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

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
        add(createUserJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, 140, 40));

        nameJTextField.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        nameJTextField.setForeground(new java.awt.Color(71, 79, 112));
        nameJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameJTextFieldFocusLost(evt);
            }
        });
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, 146, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(71, 79, 112));
        jLabel1.setText("User Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, 80, -1));

        jScrollPane1.setForeground(new java.awt.Color(71, 79, 112));

        userJTable.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 375, 179));

        jLabel2.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(71, 79, 112));
        jLabel2.setText("Password");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 507, 80, 30));

        jLabel3.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(71, 79, 112));
        jLabel3.setText("Employee");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 80, -1));

        employeeJComboBox.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        employeeJComboBox.setForeground(new java.awt.Color(71, 79, 112));
        add(employeeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 146, -1));

        backjButton1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(71, 79, 112));
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });
        add(backjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 100, 40));

        jLabel5.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(71, 79, 112));
        jLabel5.setText("Organization");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 110, -1));

        organizationJComboBox.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        organizationJComboBox.setForeground(new java.awt.Color(71, 79, 112));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 146, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(71, 79, 112));
        jLabel4.setText("Role");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 50, 20));

        roleJComboBox.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        roleJComboBox.setForeground(new java.awt.Color(71, 79, 112));
        add(roleJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 146, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 24)); // NOI18N
        jLabel7.setText("Manage User Account");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 310, -1));

        lblUserName.setForeground(new java.awt.Color(255, 51, 0));
        add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, -1, -1));

        lblAcceptedUserName.setForeground(new java.awt.Color(0, 204, 0));
        add(lblAcceptedUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, -1, -1));

        lblWarning.setForeground(new java.awt.Color(255, 0, 0));
        add(lblWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 650, -1, -1));

        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 510, 140, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/global-world-map-background-business-template-d-globe-40201747.jpg"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -4, 1300, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
        try {
            lblWarning.setText("");
            String userName = nameJTextField.getText();
            String password = String.valueOf(txtPassword.getPassword());
            if (!((userName.equals("")))) {
                if (!(password.equals(""))) {
                    if (organizationJComboBox.getSelectedItem() != null) {
                        if (employeeJComboBox.getSelectedItem() != null) {
                            if (roleJComboBox.getSelectedItem() != null) {
                                //Creating a new User account
                                Organization organization = (Organization) organizationJComboBox.getSelectedItem();
                                Employee employee = (Employee) employeeJComboBox.getSelectedItem();
                                Role role = (Role) roleJComboBox.getSelectedItem();
                                JOptionPane.showMessageDialog(null, "Account created succesfull", "Warning", JOptionPane.WARNING_MESSAGE);
                                nameJTextField.setText("");
                                txtPassword.setText("");
                                organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);

                                popData();
                            } else {
                                JOptionPane.showMessageDialog(null, "Please Select Role", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please Select Employee", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Select Organization", "Warning", JOptionPane.WARNING_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter Password", "Warning", JOptionPane.WARNING_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter User Name", "Warning", JOptionPane.WARNING_MESSAGE);

            }
        }catch(Exception ex){
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
            populateRoleComboBox(enterprise);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void nameJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameJTextFieldFocusLost
        // TODO add your handling code here:
        String userName = nameJTextField.getText();
        if (!nameJTextField.getText().isEmpty()) {
            if (!Validator.validateUserName(nameJTextField.getText())) {
                lblAcceptedUserName.setText("");
                lblUserName.setText("*Only AlphaNumeric Characters and Spaces are allowed");
                nameJTextField.setText("");
            } else if (!EcoSystem.checkIfUsernameIsUnique(nameJTextField.getText())) {
                lblUserName.setText("*" + userName + " " + "is already taken please enter new username");
                nameJTextField.setText("");
            } else {

                lblUserName.setText("");
                lblAcceptedUserName.setText(userName + " " + "is available");
            }
        }
    }//GEN-LAST:event_nameJTextFieldFocusLost

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        // TODO add your handling code here:

        String password = String.valueOf(txtPassword.getPassword());
        if (!password.isEmpty()) {
            if (!Validator.validatePassword(password)) {
                JOptionPane.showMessageDialog(null, "Password should Contain \n"
                        + "       # At least one digit\n"
                        + "       # At least one lower case letter\n"
                        + "       # At least one upper case letter\n"
                        + "       # At least one special character(!@#$%^&+=~|?)\n"
                        + "       # no whitespace allowed in the entire string\n"
                        + "       # at least eight characters");
                txtPassword.setText("");
            }
        }
    }//GEN-LAST:event_txtPasswordFocusLost

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
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
