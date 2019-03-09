/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.googleApi;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.LatLong;
import Business.Network.CountryNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ShelterWorkRequest;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import userinterface.Beneficiary.BeneficiaryManageOrganizationJPanel;
import userinterface.Beneficiary.ShelterRequestAreaJPanel;
import userinterface.EntityAdmin.EntityManageOrganizationJPanel;
import userinterface.Government.GovernmentManageOrganizationJPanel;
import userinterface.Logistics.LogisticsManageOrganizationJPanel;
import userinterface.SignUp.SignUpJPanel;

/**
 *
 * @author pooji
 */
public class HomelessDisplayJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HomelessFoundJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    StateNetwork state;
    CountryNetwork country;
    EcoSystem system;
    final Browser browser;
    BrowserView view;
    LatLong latLong;
    ShelterWorkRequest request;
    Organization organization;
    boolean temp;

    public HomelessDisplayJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, StateNetwork state, CountryNetwork country, EcoSystem system, ShelterWorkRequest request) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enterprise = enterprise;
        this.state = state;
        this.country = country;
        this.system = system;
        this.request = request;
        this.organization = organization;
        temp = true;
        lblImage.setIcon(request.getImage());
        latLong = request.getLatLong();
        browser = new Browser();
        view = new BrowserView(browser);
        //Loading the maps in html to show the marked location
        browser.loadHTML("<html>\n"
                + "<head>\n"
                + "    <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\"/>\n"
                + "    <style type=\"text/css\">\n"
                + "        html { height: 100% }\n"
                + "        body { height: 100%; margin: 0; padding: 0 }\n"
                + "        #map-canvas { height: 100% }\n"
                + "    </style>\n"
                + "    <script type=\"text/javascript\"\n"
                + "            src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyB7J1zsErb9_7jxNu5KU5kIENFObAQEbl0&sensor=false\">\n"
                + "    </script>\n"
                + "    <script type=\"text/javascript\">\n"
                + "      var map;\n"
                + "      function initialize() {\n"
                + "        var mapOptions = {\n"
                + "          center: new google.maps.LatLng(" + latLong.getLatitude() + "," + latLong.getLongitude() + "),\n"
                + "          zoom: 15\n"
                + "        };\n"
                + "        map = new google.maps.Map(document.getElementById(\"map-canvas\"),\n"
                + "            mapOptions);\n"
                + "var myLatlng = new google.maps.LatLng(" + latLong.getLatitude() + "," + latLong.getLongitude() + ");\n"
                + "               var marker = new google.maps.Marker({\n"
                + "                   position: myLatlng,\n"
                + "                   map: map,\n"
                + "                   title: 'Hello'\n"
                + "               });"
                + "      }\n"
                + "      google.maps.event.addDomListener(window, 'load', initialize);\n"
                + "\n"
                + "    </script>\n"
                + "</head>\n"
                + "<body>\n"
                + "<div id=\"map-canvas\"></div>\n"
                + "</body>\n"
                + "</html>");

        this.mapContainer.add(view, "a");
        this.mapContainer.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        mapContainer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();

        jSplitPane2.setDividerLocation(600);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        mapContainer.setLayout(new java.awt.CardLayout());
        jSplitPane2.setTopComponent(mapContainer);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnBack.setText("<< Back ");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 110, 40));
        jPanel1.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 280));

        jButton1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jButton1.setText("Valid Request");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 150, 40));

        jButton2.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jButton2.setText("Invalid Request");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 160, 40));

        btnHome.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 110, 40));

        jSplitPane2.setRightComponent(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

         userProcessContainer.remove(this);
            Component[] componentArray = userProcessContainer.getComponents();
            //Populating the previous panel LatLong value from the value elected from the Map
            if (userProcessContainer.getComponent(componentArray.length - 1) instanceof ShelterRequestAreaJPanel) {
                ShelterRequestAreaJPanel eduRequestPanel = (ShelterRequestAreaJPanel) userProcessContainer.getComponent(componentArray.length - 1);
                eduRequestPanel.populateWorkQueueTable();
            } 

            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (temp) {
            request.setPersonPresent(request.getPersonPresent() + 1);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (temp) {
            request.setPersonAbsent(request.getPersonAbsent()+ 1);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        JPanel j = account.getRole().createWorkArea(userProcessContainer, account, organization, enterprise, state, country, system);
        userProcessContainer.add("workarea1", j);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnHomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel lblImage;
    private javax.swing.JPanel mapContainer;
    // End of variables declaration//GEN-END:variables
}
